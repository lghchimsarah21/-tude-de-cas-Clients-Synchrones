package com.example.voiture_service.controller;


import com.example.voiture_service.model.Voiture;
import com.example.voiture_service.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class VoitureController {

    @Autowired
    private VoitureService voitureService;

    @GetMapping("/byClient/{clientId}")
    public ResponseEntity<Voiture> getVoitureByClient(@PathVariable Long clientId) {
        try {
            Voiture voiture = voitureService.getVoitureByClientId(clientId);
            return ResponseEntity.ok(voiture);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return ResponseEntity.status(500).build();
        }
    }

    // Endpoint de santé pour vérifier que le service fonctionne
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Service Voiture is running");
    }
}
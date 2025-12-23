package com.example.client_service.controller;


import com.example.client_service.model.Voiture;
import com.example.client_service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * Endpoint 1 : Appel avec RestTemplate
     */
    @GetMapping("/{id}/car/rest")
    public ResponseEntity<Voiture> getCarWithRestTemplate(@PathVariable Long id) {
        long startTime = System.currentTimeMillis();
        Voiture voiture = clientService.getVoitureWithRestTemplate(id);
        long duration = System.currentTimeMillis() - startTime;

        System.out.println("RestTemplate - Durée: " + duration + "ms");
        return ResponseEntity.ok(voiture);
    }

    /**
     * Endpoint 2 : Appel avec Feign
     */
    @GetMapping("/{id}/car/feign")
    public ResponseEntity<Voiture> getCarWithFeign(@PathVariable Long id) {
        long startTime = System.currentTimeMillis();
        Voiture voiture = clientService.getVoitureWithFeign(id);
        long duration = System.currentTimeMillis() - startTime;

        System.out.println("Feign - Durée: " + duration + "ms");
        return ResponseEntity.ok(voiture);
    }

    /**
     * Endpoint 3 : Appel avec WebClient
     */
    @GetMapping("/{id}/car/webclient")
    public ResponseEntity<Voiture> getCarWithWebClient(@PathVariable Long id) {
        long startTime = System.currentTimeMillis();
        Voiture voiture = clientService.getVoitureWithWebClient(id);
        long duration = System.currentTimeMillis() - startTime;

        System.out.println("WebClient - Durée: " + duration + "ms");
        return ResponseEntity.ok(voiture);
    }

    /**
     * Endpoint de santé
     */
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Service Client is running");
    }
}
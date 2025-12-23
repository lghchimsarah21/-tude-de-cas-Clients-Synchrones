package com.example.client_service.feign;



import com.example.client_service.model.Voiture;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Pour les tests sans Discovery : url = "http://localhost:8081"
// Avec Discovery : utiliser seulement le name
@FeignClient(name = "service-voiture") // , url = "http://localhost:8081")
public interface VoitureClient {

    @GetMapping("/api/cars/byClient/{clientId}")
    Voiture getVoitureByClient(@PathVariable("clientId") Long clientId);
}
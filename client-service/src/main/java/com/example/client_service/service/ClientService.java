package com.example.client_service.service;

import com.example.client_service.feign.VoitureClient;
import com.example.client_service.model.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ClientService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    // FEIGN DÉSACTIVÉ TEMPORAIREMENT
    @Autowired
     private VoitureClient voitureClient;

    // URL du service
    private static final String VOITURE_SERVICE_URL = "http://localhost:8084";

    /**
     * Méthode 1 : RestTemplate (synchrone, classique)
     */
    public Voiture getVoitureWithRestTemplate(Long clientId) {
        String url = VOITURE_SERVICE_URL + "/api/cars/byClient/" + clientId;
        return restTemplate.getForObject(url, Voiture.class);
    }

    /**
     * Méthode 2 : Feign (DÉSACTIVÉ)
     */
    public Voiture getVoitureWithFeign(Long clientId) {
        return voitureClient.getVoitureByClient(clientId);
    }

    /**
     * Méthode 3 : WebClient (asynchrone/réactif)
     */
    public Voiture getVoitureWithWebClient(Long clientId) {
        String url = VOITURE_SERVICE_URL + "/api/cars/byClient/" + clientId;

        return webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Voiture.class)
                .block(); // block() pour rendre synchrone dans ce lab
    }
}
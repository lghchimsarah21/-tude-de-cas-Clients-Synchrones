package com.example.voiture_service.service;

import com.example.voiture_service.model.Voiture;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VoitureService {

    // Données en mémoire pour éviter la dépendance à une BD
    private Map<Long, Voiture> voituresParClient = new HashMap<>();

    public VoitureService() {
        // Initialiser quelques données de test
        voituresParClient.put(1L, new Voiture(10L, "Toyota", "Yaris", 1L));
        voituresParClient.put(2L, new Voiture(11L, "Renault", "Clio", 2L));
        voituresParClient.put(3L, new Voiture(12L, "Peugeot", "208", 3L));
        voituresParClient.put(4L, new Voiture(13L, "Volkswagen", "Golf", 4L));
        voituresParClient.put(5L, new Voiture(14L, "BMW", "Serie 3", 5L));
    }

    public Voiture getVoitureByClientId(Long clientId) throws InterruptedException {
        // A1.3 - Simuler un délai de traitement (optionnel)
        // Décommenter la ligne suivante pour simuler une latence
        Thread.sleep(20); // 20ms de délai artificiel

        // Retourner la voiture ou une voiture par défaut si non trouvée
        return voituresParClient.getOrDefault(
                clientId,
                new Voiture(99L, "Unknown", "Unknown", clientId)
        );
    }
}
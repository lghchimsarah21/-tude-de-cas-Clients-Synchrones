package com.example.client_service.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    // Bean pour RestTemplate
    @Bean
    @LoadBalanced // Active le load balancing avec Eureka/Consul
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // Bean pour WebClient
    @Bean
    //  @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
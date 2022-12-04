package com.steftech.microservcie.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatwayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route( r-> r.path("/conversion-feign/**")
                        .uri("lb://currency-conversion"))
                .route( r -> r.path("/conversion/**")
                        .uri("lb://currency-conversion"))
                .route( r-> r.path("/exchange/**")
                        .uri("lb://exchange-service") )
                .build();
    }
}
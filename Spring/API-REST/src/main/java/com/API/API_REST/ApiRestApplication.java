package com.API.API_REST;

import org.springframework.boot.SpringApplication; // Importing SpringApplication class to launch the application
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importing annotation to enable auto-configuration

@SpringBootApplication // Indicates this is a Spring Boot application
public class ApiRestApplication {

    public static void main(String[] args) {
        // Entry point of the Spring Boot application
        SpringApplication.run(ApiRestApplication.class, args); // Running the application
    }
}


package com.yourdomain.devops.authservice.controller;  // adjust your package

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "Auth Service Running OK";
    }
}

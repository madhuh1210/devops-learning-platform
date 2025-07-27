package com.yourdomain.devops.authservice.controller; // <-- Or your actual package

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome! You are now logged in with GitHub OAuth.";
    }
}

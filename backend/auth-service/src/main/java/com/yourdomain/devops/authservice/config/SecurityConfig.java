package com.yourdomain.devops.authservice.config;   // Replace with your actual package name

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/health").permitAll() // Allow health endpoint
                .anyRequest().authenticated()           // All else needs login
            )
            .oauth2Login();    // Enable OAuth2 login, auto handles GitHub config from application.yml
        return http.build();
    }
}

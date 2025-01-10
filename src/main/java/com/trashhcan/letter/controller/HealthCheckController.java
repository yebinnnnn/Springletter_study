package com.trashhcan.letter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @GetMapping("/api/health")
    public ResponseEntity<String> checkHealth() {
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
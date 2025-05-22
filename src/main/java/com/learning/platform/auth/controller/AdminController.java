package com.learning.platform.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/auth-service/admin")
public class AdminController {

    @GetMapping("/secure")
    @PreAuthorize("hasRole('ADMIN')")
    public String secureEndpoint() {
        return "Hello from a secured endpoint with ADMIN role!";
    }

    @GetMapping("/dashboard")
    public ResponseEntity<String> dashboard(Principal principal) {
        return ResponseEntity.ok("Welcome admin: " + principal.getName());
    }
}

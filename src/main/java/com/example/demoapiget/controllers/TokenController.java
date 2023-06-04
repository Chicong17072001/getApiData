package com.example.demoapiget.controllers;

// import javax.sql.rowset.spi.SyncResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.example.demoapiget.models.LoginRequest;
import com.example.demoapiget.services.TokenService;

@RestController
public class TokenController {
    
    @Autowired
    private TokenService tokenService;
    @PostMapping("/token")
    public ResponseEntity<String> getToken( ) {
        // System.out.println(username);
        String token = tokenService.getToken();
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving token");
        }
    }
}

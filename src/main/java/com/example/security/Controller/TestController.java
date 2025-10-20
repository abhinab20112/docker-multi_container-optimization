package com.example.security.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is public";
    }

    @GetMapping("/secure")
    public String secureEndpoint(Authentication authentication) {
        return "Hello " + authentication.getName() + ", this is secure";
    }

}

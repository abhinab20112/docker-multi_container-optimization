package com.example.security.Controller;

import com.example.security.DTO.UserDTO;
import com.example.security.POJO.JwtPOJO;

import com.example.security.Service.JwtService;
import com.example.security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class JwtController {

    @Autowired
    private  UserService userService;


    @PostMapping("/generate")
    public JwtPOJO generateToken(@RequestBody UserDTO userDTO) {
        JwtPOJO jwtPOJO = new JwtPOJO();

        // Delegate validation to service
        if (userService.validateUser(userDTO.getUserName(), userDTO.getPassword())) {
            jwtPOJO.setAccessToken(JwtService.AccessToken(userDTO));
            jwtPOJO.setRefreshToken(JwtService.RefreshToken(userDTO));
        } else {
            throw new RuntimeException("Invalid username or password");
        }

        return jwtPOJO;
    }


}


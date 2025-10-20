package com.example.security.Controller;

import com.example.security.DTO.UserDTO;
import com.example.security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String saveUser(@RequestBody UserDTO userDTO) {
        UserDTO existingUser = userService.findUserByName(userDTO.getUserName());
        if (existingUser != null) {
            return "User already exists";
        }
        userService.saveUser(userDTO);
        return "User saved successfully";
    }
}

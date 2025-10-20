package com.example.security.Service;

import com.example.security.DTO.UserDTO;
import com.example.security.Entity.User;
import com.example.security.Repostory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void saveUser(UserDTO userDTO)
    {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);

    }
    public UserDTO findUserByName(String userName) {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            return null; // return null when not found
        }
        return new UserDTO(user.getUserName(), user.getPassword());
    }
    public boolean validateUser(String userName, String rawPassword) {
        UserDTO dbUser = findUserByName(userName);
        if (dbUser == null) return false;
        return dbUser.getPassword().equals(rawPassword);

    }
}

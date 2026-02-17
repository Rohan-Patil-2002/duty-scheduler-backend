package com.rp.duty_droid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rp.duty_droid.model.User;
import com.rp.duty_droid.repository.UserRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    //Login
    @PostMapping("/login")
    public String login(@RequestBody User loginUser) {

        User user = userRepository.findByUserId(loginUser.getUserId());

        if (user == null) {
            return "User not found";
        }

        if (!user.getPassword().equals(loginUser.getPassword())) {
            return "Invalid password";
        }

        user.setStatus("ACTIVE");
        userRepository.save(user);

        return "Login successful";
    }

    //Logout
    @PostMapping("/logout/{userId}")
    public String logout(@PathVariable Long userId) {

        User user = userRepository.findByUserId(userId);

        if (user == null) {
            return "User not found";
        }

        user.setStatus("INACTIVE");
        userRepository.save(user);

        return "Logout successful";
    }
    
 // Reset / Forgot Password
    @PostMapping("/reset-password")
    public String resetPassword(@RequestBody User request) {

        // find user by userId
        User user = userRepository.findByUserId(request.getUserId());

        if (user == null) {
            return "User not found";
        }

        // check current password
        if (!user.getPassword().equals(request.getNewPassword())) {
            return "Current password is same as new password";
        }

        // set new password
        user.setPassword(request.getNewPassword());
        userRepository.save(user);

        return "Password updated successfully";
    }

    
}

package com.example.ExpenseTrackerAPI.controller;

import com.example.ExpenseTrackerAPI.model.User;
import com.example.ExpenseTrackerAPI.model.dto.SignInInput;
import com.example.ExpenseTrackerAPI.model.dto.SignUpOutput;
import com.example.ExpenseTrackerAPI.service.AuthenticationService;
import com.example.ExpenseTrackerAPI.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("user/signup")
    public SignUpOutput signUpUser(@RequestBody User user)
    {

        return userService.signUpUser(user);
    }
    @PostMapping("patient/signIn")
    public String sigInUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String sigOutUser(String email, String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.sigOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }
    }
    @GetMapping("user")
    List<User> getAllUser()
    {
        return userService.getAllUser();
    }
}

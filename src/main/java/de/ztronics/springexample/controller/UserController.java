package de.ztronics.springexample.controller;

import de.ztronics.springexample.model.User;
import de.ztronics.springexample.service.UserService;
import de.ztronics.springexample.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final WelcomeService welcomeService;

    @Autowired
    public UserController(UserService userService, WelcomeService welcomeService) {
        this.userService = userService;
        this.welcomeService = welcomeService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        welcomeService.welcomeNewUser(savedUser);
        return savedUser;
    }

    // Weitere Methoden, wie Update, Delete etc.
}

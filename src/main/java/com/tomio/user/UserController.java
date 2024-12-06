package com.tomio.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private List<UserProfile> getUserProfiles() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    private UserProfile getUserById(@PathVariable("id")Integer id) {
        return userService.getUserById(id);
    }
    @PostMapping
    private void addUser( @RequestBody UserProfile user) {
        userService.addUser(user);
    }

}

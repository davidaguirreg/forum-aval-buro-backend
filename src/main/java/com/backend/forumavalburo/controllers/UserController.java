
package com.backend.forumavalburo.controllers;

import com.backend.forumavalburo.models.UserModel;
import com.backend.forumavalburo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;
    
    @PostMapping()
    public UserModel saveUserRequest(@RequestBody UserModel newUser){
        return this.userService.saveUser(newUser);
    }
}

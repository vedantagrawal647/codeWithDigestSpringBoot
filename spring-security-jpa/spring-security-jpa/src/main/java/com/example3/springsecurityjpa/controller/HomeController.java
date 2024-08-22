package com.example3.springsecurityjpa.controller;

import com.example3.springsecurityjpa.Repository.UserRepository;
import com.example3.springsecurityjpa.model.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String home(){
        return ("<h1>Welcome </h1>");
    }

    @GetMapping("/user")
    public String UserPortal(){
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String AdminPortal(){
        return ("<h1>Welcome Admin</h1>");
    }
}

package com.example2.springsecurityjdbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
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

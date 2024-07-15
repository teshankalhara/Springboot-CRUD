package com.example.springintro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Spring Boot";
    }

    @GetMapping("/hi")
    public String sayHi() {
        return "Hi Spring Boot";
    }

    @PostMapping("/hello")
    public String postRq() {
        return "Post Hii";
    }
}

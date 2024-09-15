package com.example.springintro.service;

import org.springframework.stereotype.Service;

import com.example.springintro.entity.User;

@Service
public interface UserService {
    User createUser(User user);
}

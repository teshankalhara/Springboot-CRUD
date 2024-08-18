package com.example.springintro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springintro.entity.Order;

@Service
public interface OrderService {
    List<Order> getAllOrders();

    Order createOrder(Order order);
}

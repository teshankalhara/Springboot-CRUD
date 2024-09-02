package com.example.springintro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springintro.dto.OrderDTO;
import com.example.springintro.entity.Order;
import com.example.springintro.entity.Product;
import com.example.springintro.service.OrderService;
import com.example.springintro.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.status(200).body(orders);
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        Order order = new Order();

        // get product Ids from order dto
        List<Long> productIds = orderDTO.getProductIds();

        List<Product> orderedProducts = new ArrayList<>();

        order.setTotalPrice(0.0);

        productIds.forEach(productId -> {
            // get product by the id
            Product product = productService.getByProductId(productId);

            // add this product to order
            if (product != null) {
                // order.getOrderedProduct().add(product);
                orderedProducts.add(product);
                // set the order's total price
                order.setTotalPrice(order.getTotalPrice() + product.getPrice());
            }
        });

        order.setOrderedProduct(orderedProducts);

        // save the order in DB
        orderService.createOrder(order);

        return ResponseEntity.status(201).body(order);
    }
}

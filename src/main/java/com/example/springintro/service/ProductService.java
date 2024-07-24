package com.example.springintro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springintro.entity.Product;

@Service
public interface ProductService {
    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product getByProductId(long id);

    Product updateProduct(Long id, Product product);
}

package com.example.springintro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.springintro.dto.ProductReqDTO;
import com.example.springintro.entity.Category;
import com.example.springintro.entity.Product;
import com.example.springintro.service.CategoryService;
import com.example.springintro.service.ProductService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(productService.getByProductId(id));
    }

    @PostMapping("products")
    public ResponseEntity<String> createProduct(@RequestBody ProductReqDTO productDTO) {
        if (productDTO.getName() == null || productDTO.getName() == "") {
            return ResponseEntity.status(422).body("Product Name Null");
        }
        if (productDTO.getPrice() == null || productDTO.getPrice() <= 0) {
            return ResponseEntity.status(422).body("Price Null or Invalid!!");
        }
        if (productDTO.getCategoryId() == null) {
            return ResponseEntity.status(422).body("Category Null!!");
        }
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        Category category = categoryService.getCategoryById(productDTO.getCategoryId());
        product.setCategory(category);
        // product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()));
        productService.createProduct(product);
        return ResponseEntity.status(201).body("Product Add Ok!!");
    }

    @PutMapping("products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductReqDTO productDTO) {
        Product updatedProduct = new Product();

        updatedProduct.setName(productDTO.getName());
        updatedProduct.setPrice(productDTO.getPrice());
        updatedProduct.setDescription(productDTO.getDescription());
        Category updateCategory = categoryService.getCategoryById(productDTO.getCategoryId());
        updatedProduct.setCategory(updateCategory);

        productService.updateProduct(id, updatedProduct);

        return ResponseEntity.status(201).body("Product Update Ok!!");
    }

}

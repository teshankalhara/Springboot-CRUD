package com.example.springintro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springintro.entity.Category;

@Service
public interface CategoryService {
    List<Category> getAllCategories();

    Category createCategory(Category category);

    Category getCategoryById(Long id);
}

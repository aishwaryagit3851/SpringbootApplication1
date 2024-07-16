package com.LaptopAdda.project.service;


import com.LaptopAdda.project.dto.ProductDto;
import com.LaptopAdda.project.exception.CategoryNotFoundException;
import com.LaptopAdda.project.model.Category;
import com.LaptopAdda.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public void addCategory(Category category){
        categoryRepository.save(category);

    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public void removeCategoryById(int id){


        if(!categoryRepository.existsById(id)){
            throw new CategoryNotFoundException("Product with id " + id + " not found");
        }

        categoryRepository.deleteById(id);
    }


    public void updateCategory(int id, Category newCategory){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " + id + " not found"));
        category.setName(newCategory.getName());
        categoryRepository.save(category);

    }

    public Category getCategoryById(int id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " + id + " not found"));
        return category;
    }
}

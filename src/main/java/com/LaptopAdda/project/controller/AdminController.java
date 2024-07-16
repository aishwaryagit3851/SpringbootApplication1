package com.LaptopAdda.project.controller;


import com.LaptopAdda.project.dto.ProductDto;
import com.LaptopAdda.project.model.Category;
import com.LaptopAdda.project.model.Product;
import com.LaptopAdda.project.service.CategoryService;
import com.LaptopAdda.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class AdminController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;


    @GetMapping("/admin/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategory();

    }

    @PostMapping("/admin/categories/add")
    public ResponseEntity<String> categoryAdd(@RequestBody Category newCategory){
        categoryService.addCategory(newCategory);
        return new ResponseEntity<>("Category created successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id){
        try {
            categoryService.removeCategoryById(id);
            return new ResponseEntity<>("Category deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/admin/categories/update/{id}")
    public  ResponseEntity<String> updateCategory(@PathVariable int id,@RequestBody Category newCategory) {
        try {
            categoryService.updateCategory(id, newCategory);
            return new ResponseEntity<>("Category updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value="/admin/categories/{id}",produces = {"application/json"})
    public Category getCategory(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }





    //Product section
    @GetMapping("/admin/products")
    public List<Product> getAllProducts(){
        return productService.getAllProduct();
    }

    @PostMapping("/admin/products/add")
    public ResponseEntity<String> productAdd(@RequestBody ProductDto productDto){
       productService.addProduct(productDto);
return new ResponseEntity<>("Product added successfylly",HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/products/delete/{id}")
    public ResponseEntity<String> productDelete(@PathVariable Long id){

        try {
            productService.removeProductById(id);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete product", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/admin/products/update/{id}")
    public ResponseEntity<String> productCategory(@PathVariable Long id,@RequestBody ProductDto newProductDto) {
        try {
            productService.updateProduct(id, newProductDto);
            return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update product", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value="/admin/products/{id}",produces = {"application/json"})
    public Product getProduct(@PathVariable Long id){
        return productService.getProductById(id);
    }}

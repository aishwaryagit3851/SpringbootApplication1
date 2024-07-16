package com.LaptopAdda.project.service;

import com.LaptopAdda.project.dto.ProductDto;
import com.LaptopAdda.project.model.Category;
import com.LaptopAdda.project.model.Product;
import com.LaptopAdda.project.repository.CategoryRepository;
import com.LaptopAdda.project.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LaptopAdda.project.exception.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
       @Autowired
       ProductRepository productRepository;

       @Autowired
    CategoryRepository categoryRepository;

       public List<Product> getAllProduct(){
           return productRepository.findAll();
       }

       public void addProduct(ProductDto productDto){

           Product product=new Product();
           product.setId(productDto.getId());
           product.setName(productDto.getName());
           Category category = categoryRepository.findById(productDto.getCategoryId())
                   .orElseThrow(() -> new EntityNotFoundException("Category not found"));
           product.setCategory(category);
           product.setPrice(productDto.getPrice());
           product.setProcessor(productDto.getProcessor());
           product.setOperatingSystem(productDto.getOperatingSystem());
           product.setOsGeneration(productDto.getOsGeneration());
           product.setRam(productDto.getRam());
           product.setMemory(productDto.getMemory());
           productRepository.save(product);

       }
    public void removeProductById(Long id){
        if(!productRepository.existsById(id)){
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }

        productRepository.deleteById(id);
    }


   public Product getProductById(Long id){

       Product product = productRepository.findById(id)
               .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
       return product;
  }
public List<Product> getAllProductsByCategoryId(int id){
         return productRepository.findAllByCategoryId(id);
 }


 public void updateProduct(Long id,ProductDto newProductDto){

           productRepository.findById(id)
             .orElseThrow(() -> new ProductNotFoundException("Category with id " + id + " not found"));
     addProduct(newProductDto);


 }



}

package com.LaptopAdda.project.repository;

import com.LaptopAdda.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}

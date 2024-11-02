package com.example.Spring_Thymeleaf_Task2.repository;

import com.example.Spring_Thymeleaf_Task2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}

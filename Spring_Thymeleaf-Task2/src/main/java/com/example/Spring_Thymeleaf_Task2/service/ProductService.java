package com.example.Spring_Thymeleaf_Task2.service;

import com.example.Spring_Thymeleaf_Task2.dto.ProductDto;

import java.util.List;

public interface ProductService {

   ProductDto addProduct(ProductDto productDto);

   List<ProductDto> displayAllProduct();

}

package com.example.Spring_Thymeleaf_Task2.service.impl;

import com.example.Spring_Thymeleaf_Task2.dto.ProductDto;
import com.example.Spring_Thymeleaf_Task2.entity.Product;
import com.example.Spring_Thymeleaf_Task2.repository.ProductRepository;
import com.example.Spring_Thymeleaf_Task2.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = convertToEntity(productDto);
        return convertToDto(productRepository.save(product));
    }

    @Override
    public List<ProductDto> displayAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToDto).toList();
    }


    public ProductDto convertToDto(Product product){
        return modelMapper.map(product,ProductDto.class);
    }

    public Product convertToEntity(ProductDto productDto){
        return modelMapper.map(productDto,Product.class);
    }

}

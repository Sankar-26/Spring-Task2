package com.example.Spring_Thymeleaf_Task2.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    @NotEmpty(message = "Name cannot be empty.")
    private String name;
    @NotNull(message = "Price cannot be empty.")
    private Double price;
    @NotEmpty(message = "Category cannot be empty.")
    private String category;
}

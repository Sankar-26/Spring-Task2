package com.example.Spring_Thymeleaf_Task2.controller;

import com.example.Spring_Thymeleaf_Task2.dto.ProductDto;
import com.example.Spring_Thymeleaf_Task2.entity.Product;
import com.example.Spring_Thymeleaf_Task2.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {

    public ProductService productService;

    @GetMapping("/index")
    public String homepage(){
        return "index";
    }

    @GetMapping("/add_product")
    public String addProduct(Model model){
        ProductDto productDto =new ProductDto();
        model.addAttribute("product",productDto);
        return "add_product";
    }

    @PostMapping("/add_product/save")
    public String saveProduct(@Valid
                              @ModelAttribute("product") ProductDto productDto,
                              BindingResult result,
                              Model model){

        if(result.hasErrors()){
            model.addAttribute("product",productDto);
            return "/add_product";
        }

        productService.addProduct(productDto);
        return "redirect:/add_product?success";
    }

    @GetMapping("/display_product")
    public String displayProduct(Model model){
        List<ProductDto> productList = productService.displayAllProduct();
        model.addAttribute("products",productList);
        return "display_product";
    }








}

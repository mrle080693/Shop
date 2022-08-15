package com.eva.shop.controller;

import com.eva.shop.entity.Product;
import com.eva.shop.exceptions.ValidationException;
import com.eva.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{nameFilter}")
    public List<Product> getAllNotEqualRegex(@PathVariable String nameFilter) throws ValidationException {
        return productService.getAllNotEqualRegex(nameFilter);
    }
}

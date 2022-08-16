package com.eva.shop.service;

import com.eva.shop.entity.Product;
import com.eva.shop.exceptions.ValidationException;
import com.eva.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllNotEqualRegex(@PathVariable String nameFilter) {
        List<Product> filteredProducts;

        try {
            List<Product> allProducts = productRepository.findAll();

            filteredProducts = allProducts
                    .stream()
                    .filter(product -> !Pattern.matches(nameFilter, product.getName())).collect(Collectors.toList());

        } catch (PatternSyntaxException | NullPointerException e) {
            throw new ValidationException("RegEx is not valid");
        }

        return filteredProducts;
    }
}

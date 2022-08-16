package com.eva.shop.service;

import com.eva.shop.entity.Product;
import com.eva.shop.exceptions.ValidationException;
import com.eva.shop.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductServiceTest {

    private ProductRepository mockedProductRepository = Mockito.mock(ProductRepository.class);
    private ProductService productService = new ProductService(mockedProductRepository);

    @Test
    void getAllNotEqualRegex_ShouldReturnCorrectResult_WhenInputIsCorrect() {
        List<Product> mockedProductRepositoryReturns;
        Product productOne = new Product(1, "ProductOne", "Very special thing");
        Product productTwo = new Product(1, "ProductTwo", "Very special thing");

        mockedProductRepositoryReturns = new ArrayList<>();
        mockedProductRepositoryReturns.add(productOne);
        mockedProductRepositoryReturns.add(productTwo);

        Mockito.when(mockedProductRepository.findAll())
                .thenReturn(mockedProductRepositoryReturns);

        List<Product> expected = new ArrayList<>();
        expected.add(productOne);

        List<Product> actual = productService.getAllNotEqualRegex("ProductTwo");

        assertEquals(expected, actual);
    }

    @Test
    void getAllNotEqualRegex_ShouldReturnValidationException_WhenInputIsNotCorrect() {
        List<Product> mockedProductRepositoryReturns;
        Product productOne = new Product(1, "ProductOne", "Very special thing");
        Product productTwo = new Product(1, "ProductTwo", "Very special thing");

        mockedProductRepositoryReturns = new ArrayList<>();
        mockedProductRepositoryReturns.add(productOne);
        mockedProductRepositoryReturns.add(productTwo);

        Mockito.when(mockedProductRepository.findAll())
                .thenReturn(mockedProductRepositoryReturns);

        Assertions.assertThrows(ValidationException.class, () -> productService.getAllNotEqualRegex("{}"));
    }

    @Test
    void getAllNotEqualRegex_ShouldReturnValidationException_WhenInputIsNull() {
        List<Product> mockedProductRepositoryReturns;
        Product productOne = new Product(1, "ProductOne", "Very special thing");
        Product productTwo = new Product(1, "ProductTwo", "Very special thing");

        mockedProductRepositoryReturns = new ArrayList<>();
        mockedProductRepositoryReturns.add(productOne);
        mockedProductRepositoryReturns.add(productTwo);

        Mockito.when(mockedProductRepository.findAll())
                .thenReturn(mockedProductRepositoryReturns);

        Assertions.assertThrows(ValidationException.class, () -> productService.getAllNotEqualRegex(null));
    }
}

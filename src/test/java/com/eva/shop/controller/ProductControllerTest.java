package com.eva.shop.controller;

import com.eva.shop.entity.Product;
import com.eva.shop.exceptions.ValidationException;
import com.eva.shop.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductControllerTest {
    private ProductService mockedProductService = Mockito.mock(ProductService.class);
    private ProductController productController = new ProductController(mockedProductService);

    @Test
    void getAllNotEqualRegex_ShouldReturnsTheSameResultAsService_WhenInputIsCorrect() {
        List<Product> mockedProductServiceReturns;
        Product productOne = new Product(1, "ProductOne", "Very special thing");
        Product productTwo = new Product(1, "ProductTwo", "Very special thing");

        mockedProductServiceReturns = new ArrayList<>();
        mockedProductServiceReturns.add(productOne);
        mockedProductServiceReturns.add(productTwo);

        Mockito.when(mockedProductService.getAllNotEqualRegex("one"))
                .thenReturn(mockedProductServiceReturns);

        List<Product> expected = new ArrayList<>();
        expected.add(productOne);
        expected.add(productTwo);

        List<Product> actual = productController.getAllNotEqualRegex("one");

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

        Mockito.when(mockedProductService.getAllNotEqualRegex("{}"))
                .thenThrow(ValidationException.class);

        Assertions.assertThrows(ValidationException.class, () -> productController.getAllNotEqualRegex("{}"));
    }

    @Test
    void getAllNotEqualRegex_ShouldReturnValidationException_WhenInputIsNull() {
        List<Product> mockedProductRepositoryReturns = new ArrayList<>();
        Product productOne = new Product(1, "ProductOne", "Very special thing");
        Product productTwo = new Product(1, "ProductTwo", "Very special thing");

        mockedProductRepositoryReturns.add(productOne);
        mockedProductRepositoryReturns.add(productTwo);

        Mockito.when(mockedProductService.getAllNotEqualRegex(null))
                .thenThrow(ValidationException.class);

        Assertions.assertThrows(ValidationException.class, () -> productController.getAllNotEqualRegex(null));
    }
}

package com.eva.shop.integrationtest;

import com.eva.shop.entity.Product;
import com.eva.shop.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "/test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ProductControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getAllNotEqualRegex_ShouldReturnCorrectStatus_WhenInputIsCorrect() throws Exception {
        final String URL = "/shop/product";

        mockMvc.perform(get(URL + "/dd"))
                .andExpect(status().is(200));
    }

    @Test
    void getAllNotEqualRegex_ShouldReturnCorrectContentType_WhenInputIsCorrect() throws Exception {
        final String URL = "/shop/product";

        mockMvc.perform(get(URL + "/dd"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getAllNotEqualRegex_ShouldReturnCorrectData_WhenInputIsCorrect() throws Exception {
        final String URL = "/shop/product";

        Product product = new Product("Name", "Description");
        productRepository.save(product);

        List<Product> savedProducts = new ArrayList<>();
        savedProducts.add(product);

        String productJson = objectMapper.writeValueAsString(savedProducts);
        mockMvc.perform(get(URL + "/dd"))
                .andExpect(content().json(productJson));
    }

    @Test
    void getAllNotEqualRegex_ShouldReturnCorrectStatus_WhenInputIsNotCorrect() throws Exception {
        final String URL = "/shop/product";

        Product product = new Product("Name", "Description");
        productRepository.save(product);

        mockMvc.perform(get(URL + "/{}"))
                .andExpect(status().is(400));
    }
}

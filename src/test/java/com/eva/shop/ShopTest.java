package com.eva.shop;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopTest {

    @Autowired
    private Shop shop;

    @Test
    void contextLoads() {
        assertThat(shop).isNotNull();
    }
}

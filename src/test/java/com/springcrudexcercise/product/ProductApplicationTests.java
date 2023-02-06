package com.springcrudexcercise.product;

import com.springcrudexcercise.product.cortoller.ProductController;
import com.springcrudexcercise.product.service.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ProductApplicationTests {

    @Autowired
    ProductController productController;
    @Autowired
    ProductService productService;

    @Test
    void contextLoads() {
        assertThat(productController).isNotNull();
		assertThat(productService).isNotNull();
    }


}

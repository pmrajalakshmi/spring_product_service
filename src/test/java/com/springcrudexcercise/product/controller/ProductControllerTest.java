package com.springcrudexcercise.product.controller;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.springcrudexcercise.product.cortoller.ProductController;
import com.springcrudexcercise.product.model.Product;
import com.springcrudexcercise.product.repository.ProductRepository;
import com.springcrudexcercise.product.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    Product product;

    @BeforeEach
    public void setup() {
        product = new Product();
        product.setId(1);
        product.setName("Hello");
    }

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(productService.getProductById(product.getId())).thenReturn(Optional.of(product));
        this.mockMvc.perform(get("/product/100")).andDo(print()).andExpect(status().isOk());
    }
}

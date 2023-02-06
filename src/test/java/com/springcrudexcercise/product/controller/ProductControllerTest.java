package com.springcrudexcercise.product.controller;

import com.springcrudexcercise.product.cortoller.ProductController;
import com.springcrudexcercise.product.model.Product;
import com.springcrudexcercise.product.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        product.setId(100);
        product.setName("Hello");
    }

    @Test
    public void getProductById_should_return_ok() throws Exception {
        //given
        when(productService.getProductById(product.getId())).thenReturn(Optional.of(product));

        //then
        this.mockMvc.perform(get("/product/100")).andDo(print()).andExpect(status().isOk());
    }
}

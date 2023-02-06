package com.springcrudexcercise.product.service;

import com.springcrudexcercise.product.exception.ProductException;
import com.springcrudexcercise.product.model.Product;
import com.springcrudexcercise.product.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    Product product;


    @BeforeEach
    public void setup() {
        product = new Product();
        product.setId(1);
        product.setName("Hello");
    }

    @Test
    public void givenProductObject_whenSave_thenReturnProductObject() {

        // given - precondition or setup
        given(productRepository.save(product)).willReturn(product);

        // when -  action or the behaviour that we are going test
        Product savedProduct = productService.saveProduct(product);

        // then
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isEqualTo(product.getId());

    }

    @Test
    public void saveProduct_without_name_shouldFail() {

       //given
        Product productWithoutName = new Product();
        productWithoutName.setId(2);

        // then
        assertThrows(ProductException.class, () -> {
            productService.saveProduct(productWithoutName);
        });
    }

    @Test
    public void saveProduct_without_id_shouldFail() {

      //given
        Product productWithoutId = new Product();
        productWithoutId.setName("testName");

        // then
        assertThrows(ProductException.class, () -> {
            productService.saveProduct(productWithoutId);
        });
    }
    @Test
    public void getProductById_should_return_valid_Product_for_exist() {
        // given - precondition or setup
        given(productRepository.findById(product.getId())).willReturn(Optional.of(product));

        // when -  action or the behaviour that we are going test
        Optional<Product> findProduct = productService.getProductById(product.getId());

        // then
        assertThat(findProduct).isNotEmpty();

        assertThat(findProduct.get().getId()).isEqualTo(product.getId());
    }
}

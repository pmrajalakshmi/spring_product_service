package com.springcrudexcercise.product.service;

import com.springcrudexcercise.product.exception.ProductException;
import com.springcrudexcercise.product.model.Product;
import com.springcrudexcercise.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(x -> products.add(x));
        return products;
    }

    public Optional<Product> getProductById(Integer productId) {
        Optional<Product> product = productRepository.findById(productId);

        if (!product.isPresent()) {
            throw new ProductException("Product not found");
        }
        return product;


    }

    private void test( String userName) {
        userName = "aaa";
    }

    public Product saveProduct(Product product) {
        validateProduct(product);
        product.setName(product.getName().toUpperCase(Locale.ROOT));
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    private void validateProduct(Product product) {
        if (product.getId() == null || product.getId().toString().trim().length() == 0) {
            throw new ProductException("Product Id must");

        }
        if (product.getName() == null || product.getName().toString().trim().length() == 0) {
            throw new ProductException("Product name must");
        }

    }
}

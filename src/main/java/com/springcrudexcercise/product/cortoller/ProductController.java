package com.springcrudexcercise.product.cortoller;

import com.springcrudexcercise.product.model.Product;
import com.springcrudexcercise.product.model.ProductErrorResponse;
import com.springcrudexcercise.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/product")
    private ResponseEntity<Object> saveProduct(@RequestBody Product product) {
        try {
            productService.saveProduct(product);
            return ResponseEntity.ok().body(product);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ProductErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/product")
    private ResponseEntity<Object> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            if (products.isEmpty()) return ResponseEntity.ok().body(new ProductErrorResponse("No Products to list"));
            return ResponseEntity.ok().body(products);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ProductErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/product/{id}")
    private ResponseEntity<Object> getByProductId(@PathVariable(value = "id") Integer productId) {
        try {
            Optional<Product> findProductResult = productService.getProductById(productId);
            if (findProductResult.isPresent()) {
                return ResponseEntity.ok().body(findProductResult.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ProductErrorResponse("No product detail for " + productId));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ProductErrorResponse("Unable to find the product"));
        }

    }
}

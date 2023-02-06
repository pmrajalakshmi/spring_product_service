package com.springcrudexcercise.product.exception;

import lombok.Getter;

@Getter
public class ProductException extends RuntimeException {

    public ProductException(String message) {
        super(message);
    }
}

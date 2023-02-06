package com.springcrudexcercise.product.repository;

import com.springcrudexcercise.product.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
}

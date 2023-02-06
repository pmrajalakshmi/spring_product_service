package com.springcrudexcercise.product.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table
public class Product {
    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private Double price;


}

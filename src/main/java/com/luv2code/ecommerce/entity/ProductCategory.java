package com.luv2code.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

// making this an entity to use it like ORM
@Entity
@Table(name="product_category")
// using getter setter annotation for getting relief from declaring them manuallay
@Getter
@Setter
public class ProductCategory {

	// specifying the col an pk
    @Id
    // specifying the generated value of pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // making it similar to the the id that we have in our actual db
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;

}








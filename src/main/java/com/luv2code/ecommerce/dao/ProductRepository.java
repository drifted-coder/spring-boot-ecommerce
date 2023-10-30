package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

// for cross-origin support on client side
@CrossOrigin("http://localhost:4200")
// extending jpa repository for all the curd operations
public interface ProductRepository extends JpaRepository<Product, Long> {
	Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
	
	Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}

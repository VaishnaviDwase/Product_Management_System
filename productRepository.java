package com.Prakshan.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Prakshan.demo.Entity.Product;

public interface productRepository extends JpaRepository<Product, Integer>{

}

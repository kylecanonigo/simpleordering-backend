package com.simpleordering.simpleorderingbackend.repositories;

import com.simpleordering.simpleorderingbackend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

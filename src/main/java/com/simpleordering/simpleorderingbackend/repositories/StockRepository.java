package com.simpleordering.simpleorderingbackend.repositories;

import com.simpleordering.simpleorderingbackend.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
}

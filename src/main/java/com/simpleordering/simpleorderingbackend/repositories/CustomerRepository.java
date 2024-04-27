package com.simpleordering.simpleorderingbackend.repositories;

import com.simpleordering.simpleorderingbackend.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

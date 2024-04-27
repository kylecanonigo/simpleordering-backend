package com.simpleordering.simpleorderingbackend.services;

import com.simpleordering.simpleorderingbackend.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int customerId);
    Customer addCustomer(Customer customer);
    Customer editCustomer(int customerId, Customer customer);
    void deleteCustomer(int customerId);
}

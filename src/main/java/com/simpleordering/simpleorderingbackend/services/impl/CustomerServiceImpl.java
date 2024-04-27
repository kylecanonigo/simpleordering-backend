package com.simpleordering.simpleorderingbackend.services.impl;

import com.simpleordering.simpleorderingbackend.models.Customer;
import com.simpleordering.simpleorderingbackend.repositories.CustomerRepository;
import com.simpleordering.simpleorderingbackend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        return customerOptional.orElse(null);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer editCustomer(int customerId, Customer updatedCustomer) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer existingCustomer = customerOptional.get();
            existingCustomer.setCustomerName(updatedCustomer.getCustomerName());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            return customerRepository.save(existingCustomer);
        } else {
            return null; // Customer with given ID not found
        }
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }
}

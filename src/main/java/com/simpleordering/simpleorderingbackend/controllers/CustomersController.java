package com.simpleordering.simpleorderingbackend.controllers;

import com.simpleordering.simpleorderingbackend.models.Customer;
import com.simpleordering.simpleorderingbackend.services.CustomerService;
import com.simpleordering.simpleorderingbackend.services.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer addedCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> editCustomer(@PathVariable int customerId, @RequestBody Customer updatedCustomer) {
        Customer editedCustomer = customerService.editCustomer(customerId, updatedCustomer);
        if (editedCustomer != null) {
            return new ResponseEntity<>(editedCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

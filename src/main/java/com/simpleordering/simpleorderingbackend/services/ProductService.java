package com.simpleordering.simpleorderingbackend.services;

import com.simpleordering.simpleorderingbackend.models.Customer;
import com.simpleordering.simpleorderingbackend.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int productId);
    Product addProduct(Product product);
    Product editProduct(int productId, Product product);
    void deleteProduct(int productId);
}

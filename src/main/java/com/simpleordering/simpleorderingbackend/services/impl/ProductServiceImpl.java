package com.simpleordering.simpleorderingbackend.services.impl;

import com.simpleordering.simpleorderingbackend.models.Product;
import com.simpleordering.simpleorderingbackend.repositories.ProductRepository;
import com.simpleordering.simpleorderingbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.orElse(null);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product editProduct(int productId, Product updatedProduct) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            existingProduct.setProductPrice(updatedProduct.getProductPrice());
            existingProduct.setProductType(updatedProduct.getProductType());
            return productRepository.save(existingProduct);
        } else {
            return null; // Product with given ID not found
        }
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }
}

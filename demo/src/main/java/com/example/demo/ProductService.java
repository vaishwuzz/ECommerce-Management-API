package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public String updateProduct(Product product) {
        if (productRepository.existsById(product.getProductId())) {
            productRepository.save(product);
            return "Success";
        } else {
            return "Failure: Product not found";
        }
    }

    public String deleteProduct(Long productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            return "Success";
        } else {
            return "Failure: Product not found";
        }
    }
}

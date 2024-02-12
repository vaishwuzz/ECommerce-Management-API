package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Object> getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        try {
            Product createdProduct = productService.createProduct(product);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        String result = productService.updateProduct(product);
        return new ResponseEntity<>(result, result.startsWith("Success") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        String result = productService.deleteProduct(productId);
        return new ResponseEntity<>(result, result.startsWith("Success") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}

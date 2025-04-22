package com.crudProduct.thymeleaf.service;

import com.crudProduct.thymeleaf.entity.Product;
import com.crudProduct.thymeleaf.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public void saveProduct(Product product) {
        productRepository.save(product);
    }


    public Product getProductById(Long id) {
        Optional<Product> optional = productRepository.findById(id);
        return optional.orElseThrow(() -> new RuntimeException("Product not found for ID: " + id));
    }


    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}

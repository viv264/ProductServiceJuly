package com.scaler.productservicejul24.services;

import com.scaler.productservicejul24.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id);
    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product);
}

package com.scaler.productservicejul24.services;

import com.scaler.productservicejul24.exceptions.ProductNotExistsException;
import com.scaler.productservicejul24.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotExistsException;
    List<Product> getAllProducts();
    Product updateProduct(Long id, Product product);
    Product replaceProduct(Long id, Product product);
    Product addNewProduct(Product product);
    boolean deleteProduct(Long id);
}

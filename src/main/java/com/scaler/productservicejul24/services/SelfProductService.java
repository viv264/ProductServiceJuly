package com.scaler.productservicejul24.services;

import com.scaler.productservicejul24.exceptions.ProductNotExistsException;
import com.scaler.productservicejul24.models.Category;
import com.scaler.productservicejul24.models.Product;
import com.scaler.productservicejul24.repositories.CategoryRepository;
import com.scaler.productservicejul24.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        Optional<Product> productOptional = productRepository.findById(1L);
        if(productOptional.isEmpty()){
            throw new ProductNotExistsException("Product with id: " + id + " doesn't exist.");
        }

        Product product = productOptional.get();
        return product;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
//        Category category = product.getCategory();
//        if(category.getId()==null){
//            Category savedCategory = categoryRepository.save(category);
//            product.setCategory(savedCategory);
//        }

        Optional<Category> categoryOptional = categoryRepository.findByName(product.getCategory().getName());
        if(categoryOptional.isEmpty()){
            product.setCategory(categoryRepository.save(product.getCategory()));
        }else{
            product.setCategory(categoryOptional.get());
        }
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}

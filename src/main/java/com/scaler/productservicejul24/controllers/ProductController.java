package com.scaler.productservicejul24.controllers;

import com.scaler.productservicejul24.exceptions.ProductNotExistsException;
import com.scaler.productservicejul24.models.Product;
import com.scaler.productservicejul24.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //Controller_Product
    private ProductService productService;
    private RestTemplate restTemplate;

    @Autowired
    public ProductController(@Qualifier("selfProductService") ProductService productService, RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        ResponseEntity<List<Product>> response = new ResponseEntity<>(
                productService.getAllProducts(), HttpStatus.NOT_FOUND
        );
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotExistsException {
        //throw new RuntimeException("Something went wrong");
        //try{
            return new ResponseEntity<>(
                    productService.getSingleProduct(id),
                    HttpStatus.OK
            );
//        }catch (ArithmeticException exception){
//            ResponseEntity<Product> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            return response;
//        }
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
//        Product p = new Product();
//        p.setTitle("New Product");
        return productService.addNewProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteMapping(@PathVariable("id") Long id){
        //return new ResponseEntity<>(HttpStatus.OK);
    }

//    @ExceptionHandler(ProductNotExistsException.class)
//    public ResponseEntity<Void> handleProductNotExistsException(){
//        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//    }
}

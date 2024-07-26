package com.scaler.productservicejul24;

import com.scaler.productservicejul24.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Productservicejul24Application {

    public static void main(String[] args) {

        SpringApplication.run(Productservicejul24Application.class, args);

        Product product = new Product();
        product.getId();
        product.setId(123L);
    }

}

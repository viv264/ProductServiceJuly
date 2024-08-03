package com.scaler.productservicejul24.services;

import com.scaler.productservicejul24.dtos.FakeStoreProductDto;
import com.scaler.productservicejul24.exceptions.ProductNotExistsException;
import com.scaler.productservicejul24.models.Category;
import com.scaler.productservicejul24.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProduct){
        Product product = new Product();
        product.setTitle(fakeStoreProduct.getTitle());
        product.setId(fakeStoreProduct.getId());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageUrl(fakeStoreProduct.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProduct.getCategory());

        return product;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        //throw new RuntimeException("Something stupid has happened.");
        //int x=1/0;
        FakeStoreProductDto productDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class
        );

        if(productDto == null){
            throw new ProductNotExistsException(
                    "Product with id " + id + " doesn't exist."
            );
        }
        return convertFakeStoreProductToProduct(productDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                     FakeStoreProductDto[].class
        );
        //beacuse list uses generics and convert it into hashmap which creates problem so use array

        List<Product> answer = new ArrayList<>();

        for(FakeStoreProductDto dto : response){
            answer.add(convertFakeStoreProductToProduct(dto));
        }

        return answer;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(new FakeStoreProductDto(), FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakeStoreProductToProduct(response);
    }
}

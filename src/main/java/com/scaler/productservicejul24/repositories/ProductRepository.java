package com.scaler.productservicejul24.repositories;

import com.scaler.productservicejul24.models.Category;
import com.scaler.productservicejul24.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitleContaining(String word);

    long deleteByTitle(String title);

    List<Product> findByTitleAndDescription(String title, String description);

    List<Product> findByPriceLessThanEqual(double price);

    List<Product> findByPriceBetween(double startRange, double endRange);

    List<Product> findByCategory(Category category);

    List<Product> findByCategory_Id(Long id);

    Optional<Product> findById(Long id);
    //this will return null if no product matches the id so use optional

    Product save(Product product);

}

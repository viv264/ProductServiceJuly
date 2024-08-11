package com.scaler.productservicejul24.repositories;

import com.scaler.productservicejul24.models.Category;
import com.scaler.productservicejul24.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    //Category save(Category category);
    Optional<Category> findByName(String name);
}

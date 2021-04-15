package com.online.product.repository;

import com.online.product.dto.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

    List<Product> findByCategoryName(String categoryName);
}

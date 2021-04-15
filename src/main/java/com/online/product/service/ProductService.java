package com.online.product.service;

import com.online.product.dto.Product;
import com.online.product.exception.ServiceException;
import com.online.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    List<Product> productList = new ArrayList<>();

    public String addProduct(Product product) {
        if (product.getPrice() == 0 && product.getDiscount() > 0) {
            throw new ServiceException("No discount allowed for 0 product price");
        }
        productRepository.save(product);
        return "Success";
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> productCategoryList(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    public Product productById(Integer id) {

        return productRepository.findById(id).get();
    }

    public String updateProduct(Product product) {
        productRepository.save(product);
        return "product updated.";

    }

    public String deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return "product deleted.";
    }
}

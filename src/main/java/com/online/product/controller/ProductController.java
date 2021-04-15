package com.online.product.controller;

import com.online.product.dto.Product;
import com.online.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "v1/productAPI")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "welcome")
    public String hello() {
        return "Welcome to the product service";
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody @Valid Product product) {
        String status = productService.addProduct(product);
        log.info("product added status - {}", status);
        return ResponseEntity.status(HttpStatus.CREATED).body(status);
    }

    @GetMapping("/productList")
    public List<Product> productList() {
        return productService.listAllProducts();
    }

    @GetMapping("/productList/{categoryName}")
    public List<Product> productList(@PathVariable String categoryName) {
        return productService.productCategoryList(categoryName);
    }

    @GetMapping("/products/{id}")
    public Product productById(@PathVariable Integer id) {
        return productService.productById(id);
    }

    @PutMapping("/updateProduct")
    public String updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }
}

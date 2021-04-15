package com.online.product.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Document(collection = "Product")
@Data
public class Product {
    @Id
    private Integer id;
    @NotNull(message = "product name should not be null")
    private String name;
    @NotNull(message = "Category name should not be null")
    private Category category;
    @Min(value = 0, message = "price should not be negative")
    private Double price;
    @Min(value = 0, message = "Discount should not be negative")
    @Max(value = 25, message = "Discount should be between 0 - 25%.")
    private Double discount;
    private String discountDescription;

}

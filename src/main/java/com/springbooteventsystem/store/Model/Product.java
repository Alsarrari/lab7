package com.springbooteventsystem.store.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    @NotNull(message = "id cannot  found")
    private String id;
    @NotNull(message = "name cannot  found ")
    private String name;
    @NotNull(message = "price cannot  found ")
    private double price;
    @NotNull(message = "category cannot found")
    private String categoryId;
}

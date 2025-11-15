package com.springbooteventsystem.store.Controller;

import com.springbooteventsystem.store.Model.Product;
import com.springbooteventsystem.store.Servise.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/p1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(200).body(productService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@PathVariable @Valid Product product){
        productService.addProduct(product);
        return ResponseEntity.status(200).body("");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id , Errors errors){
        boolean delete = productService.deleteProduct(id);
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body("id not found");
        }
        return ResponseEntity.status(200).body("product delete");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> upDate(@PathVariable @Valid int id ,@RequestBody Product product){
        boolean update=productService.upDateProduct(id, product);
        if (!update){
            return ResponseEntity.status(400).body("id not found");
        }
        return ResponseEntity.status(200).body("producct update");

    }
    @GetMapping("/search/{name}")
    public ResponseEntity<?> search(@PathVariable String name) {

        Product result = productService.getProductByName(name);

        if (result == null) {
            return ResponseEntity.status(400).body("Product not found");
        }

        return ResponseEntity.status(200).body(result);
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity getProductsByCategory(@PathVariable String categoryId) {

        ArrayList<Product> products = productService.getProductsByCategory(categoryId);

        if (products.isEmpty()) {
            return ResponseEntity.status(400).body("No products found for this category");
        }

        return ResponseEntity.status(200).body(products);
    }




}

package com.springbooteventsystem.store.Controller;

import com.springbooteventsystem.store.Model.Category;
import com.springbooteventsystem.store.Servise.CategoryServise;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/c1/category")
public class CategoryController {
    private final CategoryServise categoryServise;

    public CategoryController(CategoryServise categoryServise) {
        this.categoryServise = categoryServise;
    }
    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(200).body(categoryServise.getCategory());
    }
    @PostMapping("/add")
    public ResponseEntity<?> addCategory(Category category){
        categoryServise.addCategory(category);
        return ResponseEntity.status(200).body("add category");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int  id ){
        boolean isdelete = categoryServise.deleteCategory(id);
        if ((isdelete)){
            return ResponseEntity.status(400).body("id not found");
        }
    return ResponseEntity.status(200).body("delete successfully");
    }
    @PutMapping("/upDate/{id}")
    public ResponseEntity<?> upDate(@PathVariable int id ,@RequestBody @Valid Category category){
        boolean isUpdate=categoryServise.upDate(id, category);
        if (isUpdate){
            return ResponseEntity.status(400).body("id not found");

        }
        return ResponseEntity.status(200).body("updata successfully");
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<?> search(@PathVariable String name){
        Category result=categoryServise.getbyname(name);
        if (result==null){
            return ResponseEntity.status(400).body("category not found");
        }
        return ResponseEntity.status(200).body(result);
    }


}

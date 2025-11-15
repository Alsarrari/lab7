package com.springbooteventsystem.store.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    @NotNull(message = "cannot be invalid")
    @Size(min = 0,max = 20 ,message = "must the id ")
    private String id ;
    @NotNull(message = "name cannot be found")
    private String name ;
    @NotNull(message = "description cannot be nul")
    private String description;



}

package com.springbooteventsystem.store.Servise;

import com.springbooteventsystem.store.Model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryServise {
    private final ArrayList<Category>categories=new ArrayList<>();

    public ArrayList getCategory(){
        return categories;
    }
    public void addCategory(Category category){
        categories.add(category);
    }
    public boolean upDate(int id , Category category){
        if (id>categories.size()){

            return false;
        }
        categories.set(id,category);
        return true;
    }

    public boolean deleteCategory(int id ){
        if (id>categories.size()){
            return false;
        }
        categories.remove(id);
        return true;
    }

    public Category getbyname(String name){
        for (Category cate :categories){
            if (cate.getName().equalsIgnoreCase(name)){
                return cate;
            }
        }
        return null;
    }



}

package com.springbooteventsystem.store.Servise;

import com.springbooteventsystem.store.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product>broducts=new ArrayList<>();
    public ArrayList<Product> getAll(){
        return broducts;
    }
    public void addProduct(Product broduct){
        broducts.add(broduct);
    }
    public boolean upDateProduct(int id , Product broduct ){
        if (id>broducts.size()){
            return false;
        }
        broducts.set(id, broduct);
        return true;

    }
    public boolean deleteProduct(int id){
        if (id>broducts.size()){
            return false;
        }
        broducts.remove(id);
        return true;

    }

    public Product getProductByName(String name) {

        for (Product p : broducts) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
    public ArrayList<Product> getProductsByCategory(String categoryId) {

        ArrayList<Product> result = new ArrayList<>();

        for (Product pro  : broducts) {
            if (pro.getCategoryId().equals(categoryId)) {
                result.add(pro);
            }
        }

        return result;
    }




}

package com.booleanuk.api.products;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

public class ProductRepository {
    private ArrayList<Product> products;

    public ProductRepository()  {
        this.products = new ArrayList<>();
    }

    public ArrayList<Product> findAll() {
        return this.products;
    }

    public Product findOneProduct(int id)   {
        for(Product product : this.products)    {
            if(product.getID() == id)
                return product;
        }
        return null;
    }

    public Product addOne(Product product)  {
        this.products.add(product);
        return product;
    }

    public Product updateOne(int id, Product product)   {
        Product productToUpdate = findOneProduct(id);
        if(productToUpdate != null) {
            productToUpdate.setName(product.getName());
            productToUpdate.setCategory(product.getCategory());
            productToUpdate.setPrice(product.getPrice());
            return findOneProduct(id);
        }
        return null;
    }

    public Product removeOne(int id)  {
        Product productToDelete = findOneProduct(id);
        if(productToDelete != null) {
            this.products.remove(productToDelete);
            return productToDelete;
        }
        return null;
    }
}

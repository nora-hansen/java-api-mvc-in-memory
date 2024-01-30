package com.booleanuk.api.products;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("products")
public class ProductController {
    ProductRepository productRepo = new ProductRepository();

    public ProductController()  {

    }

    @GetMapping
    public ArrayList<Product> getAll(@RequestParam (required = false) String category)  {
        if(category != null)
            return this.productRepo.findAll(category);
        return this.productRepo.findAll();
    }

    @GetMapping("{id}")
    public Product getOne(@PathVariable int id) {
        if(this.productRepo.findOneProduct(id) == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        return this.productRepo.findOneProduct(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        if(product.getCategory() == null || product.getName()  == null || product.getPrice() == 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more fields are null");
        return this.productRepo.addOne(product);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@PathVariable int id, @RequestBody Product product)   {
        if(product.getCategory() == null || product.getName()  == null || product.getPrice() == 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more fields are null");
        if(this.productRepo.findOneProduct(id) == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        return this.productRepo.updateOne(id, product);
    }

    @DeleteMapping("{id}")
    public Product delete(@PathVariable int id) {
        if(this.productRepo.findOneProduct(id) == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        return this.productRepo.removeOne(id);
    }
}

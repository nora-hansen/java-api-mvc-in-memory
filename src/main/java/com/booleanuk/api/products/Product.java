package com.booleanuk.api.products;

public class Product {
    private static int nextID;
    private int ID;
    private String name;
    private String category;
    private Integer price;

    public Product() {}

    public Product(String name, String category, int price) {
        this.ID = nextID;
        nextID++;
        this.name     = name;
        this.category = category;
        this.price    = price;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

package com.example.sadeghshop.Models;

import java.util.HashMap;

public class Item {
    private int id;
    private String title;
    private String description;
    private int price;
    private int image;
    private String brand;
    private HashMap<String, String> specs;

    public Item(int id, String title, String description, int price, int image,
                HashMap<String, String> specs) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.specs = specs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public HashMap<String, String> getSpecs() {
        return specs;
    }

    public void setSpecs(HashMap<String, String> specs) {
        this.specs = specs;
    }
}

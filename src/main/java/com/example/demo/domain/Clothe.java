package com.example.demo.domain;

public class Clothe {
    private Integer id;
    private String category;
    private String gender;
    private String color;
    private String price;
    private String size;


    @Override
    public String toString() {
        return "Clothe{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", gender='" + gender + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}

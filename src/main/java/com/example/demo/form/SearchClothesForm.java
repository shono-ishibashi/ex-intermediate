package com.example.demo.form;

import javax.validation.constraints.NotNull;

public class SearchClothesForm {
    @NotNull(message = "性別を選択してください")
    private String gender;

    @NotNull(message = "色を選択してください")
    private String color;


//    getter setter
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
}

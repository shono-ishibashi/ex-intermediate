package com.example.demo.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SearchHotelForm {
    @Pattern(regexp = "\\d{0,8}",message = "8桁までの数値を入力してください")
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

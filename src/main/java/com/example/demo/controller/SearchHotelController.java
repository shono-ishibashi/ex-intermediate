package com.example.demo.controller;

import com.example.demo.domain.Hotel;
import com.example.demo.form.SearchHotelForm;
import com.example.demo.service.SearchHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("search-hotel")
public class SearchHotelController {

    @Autowired
    private SearchHotelService searchHotelService;

    @ModelAttribute
    public SearchHotelForm setUpForm(){
        return new SearchHotelForm();
    }

    @RequestMapping("")
    public String index(){
        return "hotel/hotel-search";
    }

    @RequestMapping("/result")
    public String result(@Validated
            SearchHotelForm form
            , BindingResult result
            , Model model){

        if(result.hasErrors()){
            return index();
        }
        String price = form.getPrice();
        List<Hotel> hotelList = searchHotelService.searchHotelByPrice(price);
        model.addAttribute("hotelList",hotelList);
        return index();
    }
}

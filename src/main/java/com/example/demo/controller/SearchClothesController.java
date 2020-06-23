package com.example.demo.controller;

import com.example.demo.domain.Clothe;
import com.example.demo.form.SearchClothesForm;
import com.example.demo.service.SearchClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/clothe-search")
public class SearchClothesController {

    @Autowired
    private SearchClothesService searchClothesService;

    @ModelAttribute
    public SearchClothesForm setUpForm(){
        return new SearchClothesForm();
    }

    @RequestMapping("")
    public String index(Model model){
        List<String> colorList = new ArrayList<>();
        colorList.add("赤");
        colorList.add("青");
        colorList.add("白");
        colorList.add("黄");

        model.addAttribute("colorListInput",colorList);

        return "search-clothe/search-clothe";
    }

    @RequestMapping("/result")
    public String result(
            @Validated
            SearchClothesForm form
            , BindingResult result
            , Model model){

        if(result.hasErrors()){
            return index(model);
        }

        List<Clothe> clotheList = searchClothesService.findClotheByGenderAndColor(form);
        if (clotheList.isEmpty()){
            model.addAttribute("isEmpty",true);
        }
        model.addAttribute("clotheList",clotheList);
        return index(model);
    }
}

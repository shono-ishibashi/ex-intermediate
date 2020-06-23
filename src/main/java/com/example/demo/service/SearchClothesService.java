package com.example.demo.service;

import com.example.demo.domain.Clothe;
import com.example.demo.form.SearchClothesForm;
import com.example.demo.repository.SearchClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchClothesService {
    @Autowired
    private SearchClothesRepository searchClothesRepository;

    public List<Clothe> findClotheByGenderAndColor(SearchClothesForm form){
        List<Clothe> clotheList = searchClothesRepository.findClotheByGenderAndColor(form);
        return clotheList;
    }

}

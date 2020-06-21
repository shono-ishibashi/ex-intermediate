package com.example.demo.service;

import com.example.demo.domain.Hotel;
import com.example.demo.repository.SearchHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SearchHotelService {

    @Autowired
    private SearchHotelRepository searchHotelRepository;

    public List<Hotel> searchHotelByPrice(String price){
        List<Hotel> hotelList;
        if(price.isEmpty()){
            hotelList = searchHotelRepository.findAll();
            return hotelList;
        }else{
            hotelList = searchHotelRepository.findHotelUnderThisPrice(price);
            return hotelList;
        }
    }
}

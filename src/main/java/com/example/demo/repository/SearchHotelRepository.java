package com.example.demo.repository;

import com.example.demo.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SearchHotelRepository {

    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs , i) -> {
        Hotel hotel = new Hotel();
        hotel.setId(rs.getInt("id"));
        hotel.setAreaName(rs.getString("area_name"));
        hotel.setHotelName(rs.getString("hotel_name"));
        hotel.setAddress(rs.getString("address"));
        hotel.setNearestStation(rs.getString("nearest_station"));
        hotel.setPrice(rs.getInt("price"));
        hotel.setParking(isParking(rs.getString("parking")));
        return hotel;
    };

    public static boolean isParking(String parking) {
        if(parking.equals("あり")){
            return true;
        }else{
            return false;
        }
    }

    @Autowired
    private NamedParameterJdbcTemplate template;

    public List<Hotel> findHotelUnderThisPrice(String price){
        String sql = "SELECT * FROM hotels WHERE price <= :price";
        SqlParameterSource param = new MapSqlParameterSource().addValue("price", Integer.valueOf(price));
        List<Hotel> hotelList = template.query(sql, param,HOTEL_ROW_MAPPER);
        return hotelList;
    }

    public List<Hotel> findAll(){
        String sql = "SELECT * FROM hotels ";
        List<Hotel> hotelList = template.query(sql,HOTEL_ROW_MAPPER);
        return hotelList;
    }


}

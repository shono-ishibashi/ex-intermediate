package com.example.demo.repository;

import com.example.demo.domain.Clothe;
import com.example.demo.form.SearchClothesForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SearchClothesRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Clothe> CLOTHE_ROW_MAPPER = (rs, i) -> {
        Clothe clothe = new Clothe();
        clothe.setId(rs.getInt("id"));
        clothe.setCategory(rs.getString("category"));
        clothe.setGender(rs.getString("gender"));
        clothe.setColor(rs.getString("color"));
        clothe.setPrice(rs.getString("price"));
        clothe.setSize(rs.getString("size"));
        return clothe;
    };

    public List<Clothe> findClotheByGenderAndColor(SearchClothesForm form){
        String sql = "SELECT * FROM clothes WHERE gender = :gender AND color = :color ORDER BY price";
        SqlParameterSource param = new MapSqlParameterSource().addValue("gender", Integer.valueOf(form.getGender())).addValue("color",form.getColor());
        List<Clothe> clotheList = template.query(sql,param,CLOTHE_ROW_MAPPER);
        return clotheList;
    }
}

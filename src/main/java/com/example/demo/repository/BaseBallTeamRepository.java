package com.example.demo.repository;

import com.example.demo.domain.BaseBallTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseBallTeamRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<BaseBallTeam> BASE_BALL_TEAM_ROW_Mapper = (rs,rowNum) -> {
        BaseBallTeam team = new BaseBallTeam();
        team.setId(rs.getInt("id"));
        team.setLeagueName(rs.getString("league_name"));
        team.setTeamName(rs.getString("team_name"));
        team.setHeadquarters(rs.getString("headquarters"));
        team.setInauguration(rs.getString("inauguration"));
        team.setHistory(rs.getString("history"));
        return team;
    };

    /**
     * チーム全件を検索、抽出するメソッド
     * @return 検索してきたチームが格納されているList
     */
    public List<BaseBallTeam> findAll(){
        String sql = "SELECT * FROM teams ORDER BY inauguration";
        List<BaseBallTeam> teams = template.query(sql, BASE_BALL_TEAM_ROW_Mapper);
        return teams;
    }


    public BaseBallTeam load(Integer id){

        String sql = "SELECT * FROM teams WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

        try{
            BaseBallTeam team = template.queryForObject(sql,param ,BASE_BALL_TEAM_ROW_Mapper);
            return team;
        }catch(Exception ex){
            return null;
        }
    }

}

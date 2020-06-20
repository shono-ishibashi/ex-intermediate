package com.example.demo.service;

import com.example.demo.domain.BaseBallTeam;
import com.example.demo.repository.BaseBallTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseBallTeamService {
    @Autowired
    private BaseBallTeamRepository baseBallTeamRepository;


    public List<BaseBallTeam> showList(){
        List<BaseBallTeam> teams = baseBallTeamRepository.findAll();
        return teams;
    }

    public BaseBallTeam showDetail(Integer id){
        BaseBallTeam team = baseBallTeamRepository.load(id);
        return team;
    }



}

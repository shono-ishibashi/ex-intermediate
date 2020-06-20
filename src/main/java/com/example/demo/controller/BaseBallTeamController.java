package com.example.demo.controller;

import com.example.demo.domain.BaseBallTeam;
import com.example.demo.service.BaseBallTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/baseball")
public class BaseBallTeamController {

    @Autowired
    private BaseBallTeamService baseBallTeamService;

    @RequestMapping("")
    public String teamList(Model model){
        List<BaseBallTeam> teams = baseBallTeamService.showList();
        model.addAttribute("BaseBallTeam",teams);
        return "baseballteam/list";
    }

    @RequestMapping("/detail/{id}")
    public String showDetail(@PathVariable ("id") Integer id,Model model){
        BaseBallTeam team = baseBallTeamService.showDetail(id);
        String teamHistory = team.getHistory();
        teamHistory = teamHistory.replaceAll("\r\n|\r|\n", "<br/>");
        team.setHistory(teamHistory);
        model.addAttribute("teamDetail",team);
        return "baseballteam/detail";
    }
}

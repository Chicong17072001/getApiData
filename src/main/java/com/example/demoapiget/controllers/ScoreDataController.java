package com.example.demoapiget.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demoapiget.models.DataEntry;
// import com.example.demoapiget.models.ScoreData;
import com.example.demoapiget.services.DataService;

public class ScoreDataController {
    private DataService dataService;
    
    @Autowired
    public ScoreDataController(DataService dataService) {
        this.dataService = dataService;
    }
    
    @GetMapping("/scoreData")
    public List<DataEntry> getScoreDataByDate(@RequestParam("date") String date) {
        List<DataEntry> scoreDataList = dataService.getScoreDataByDate(date);
        return scoreDataList;
    }
}

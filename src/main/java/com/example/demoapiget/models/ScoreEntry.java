package com.example.demoapiget.models;

import java.util.List;

import lombok.Data;



@Data
public class ScoreEntry {
    private String id;
    private String type;
    private int score;
    private List<ScoreData> data;
}

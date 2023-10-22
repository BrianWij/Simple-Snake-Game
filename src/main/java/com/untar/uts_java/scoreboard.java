package com.untar.uts_java;

public class scoreboard {

    private String name;
    private String score;

    public scoreboard(String name, String score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;
    }
    public String getScore(){
        return score;
    }
}

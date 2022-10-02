package com.example.quiz;

import android.content.SharedPreferences;

public class InitApp {

    int levelUser = 1;

    public int getCurrentLevel()
    {
        return levelUser;
    }
    public void addLevel()
    {
        levelUser++;
    }

    // Pegar pergunta do bando de dados - getQuestion()
    // Pegar opções - getAnwser()
    // Pegar dica - getTip()
}

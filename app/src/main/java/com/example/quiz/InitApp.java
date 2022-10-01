package com.example.quiz;

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

    // Atualizar level - addLevel()
    // Pegar pergunta do bando de dados - getQuestion()
    // Pegar opções - getAnwser()
    // Pegar dica - getTip()
}

package com.example.quiz;

import android.widget.TextView;

public class UpdateUI {

    TextView counter;

    public void InitComponentsUI(TextView counter)
    {
        this.counter = counter;
    }
    public void setCounter(String value)
    {
        counter.setText(value);
    }
    public void NextLevel()
    {
        // Pula para a próxima fase
        // - Obter nova pergunta
        // - Obter novas opções
        // - Obter nova dica
        // - Obter nova pergunta certa
    }
}

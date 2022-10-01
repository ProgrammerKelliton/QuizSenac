package com.example.quiz;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class CheckResponse {

    TextView resp;
    InitApp init = new InitApp();
    UpdateUI uptUI = new UpdateUI();
    int count = 0;

    public void OnClickBtn(Button btn)
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateUI(btn.getText().toString());
            }
        });
    }
    private void UpdateUI(String userRespose)
    {
        if(ConfirmRespose(userRespose))
        {
            // uptUI - Atualiza a UI
            init.addLevel();
        }
        else
        {
            // Caso jogador erre mostre para ele que ele errou e depois atualize a UI
            StartCounter(30);
        }
    }
    private boolean ConfirmRespose(String userRespose)
    {
        // Falta obter a resposta do db

        if(userRespose == "resposta do db")
        {
            return true;
        }
        return false;
    }
    private void StartCounter(int time)
    {
        count = time;

        Timer t = new Timer();
        TimerTask ts = new TimerTask() {
            @Override
            public void run() {
                if(count == 0)
                {
                    // Atualiza a UI
                    t.cancel();
                }
                else
                {
                    // Mostra a contagem regressiva e depois quando count for igual a 0 atualia a UI
                    uptUI.setCounter(String.valueOf(count)); // App está fechando
                    count--;
                }
            }
        };
        t.schedule(ts, 0, 100);
    }
}

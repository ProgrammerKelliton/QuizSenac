package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class result extends AppCompatActivity {

    TextView win;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        win = findViewById(R.id.win);
        String winResult = getIntent().getStringExtra("win");

        if(Boolean.parseBoolean(winResult))
        {
            win.setText("Você acertou !");
        }
        else
        {
            win.setText("Você errou !");
        }
    }
}
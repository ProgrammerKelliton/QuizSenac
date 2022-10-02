package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class result extends AppCompatActivity {

    TextView win;
    ImageView background;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        win = findViewById(R.id.win);
        background = findViewById(R.id.background);
        btnConfirm = findViewById(R.id.btnConfirm);

        String winResult = getIntent().getStringExtra("win");

        if(Boolean.parseBoolean(winResult))
        {
            background.setImageResource(R.drawable.win);
            win.setText("Você acertou !");
        }
        else
        {
            background.setImageResource(R.drawable.nowingame);
            win.setText("Você errou !");
        }
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(result.this, MainActivity.class);
                startActivity(next);
            }
        });
    }
}
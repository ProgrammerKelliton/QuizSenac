package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button ans1, ans2, ans3;
    TextView level, question;
    InitApp init;
    CheckResponse check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Procurando elementos da View
        level = findViewById(R.id.level);
        ans1 = findViewById(R.id.ans_A);
        ans2 = findViewById(R.id.ans_B);
        ans3 = findViewById(R.id.ans_C);
        question = findViewById(R.id.question);

        // Iniciando o App
        init = new InitApp();
        level.setText("Level " + init.getCurrentLevel());

        // Verificando se resposta é correta
        check = new CheckResponse();
        OnClickBtn(ans1);
        OnClickBtn(ans2);
        OnClickBtn(ans3);
    }
    private void UpdateUI(String userRespose) {

        if (check.ConfirmRespose(userRespose)) {
            init.addLevel();

            Intent result = new Intent(MainActivity.this, com.example.quiz.result.class);
            result.putExtra("win", true);
            startActivity(result);
        } else {
            Intent result = new Intent(MainActivity.this, com.example.quiz.result.class);
            result.putExtra("win", false);
            startActivity(result);
        }

    }
    private void OnClickBtn(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateUI(btn.getText().toString());
            }
        });
    }
}
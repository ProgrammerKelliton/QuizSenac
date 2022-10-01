package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button ans1, ans2, ans3;
    TextView level, question;
    InitApp init;
    CheckResponse check;
    UpdateUI uptdUI;

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
        check.OnClickBtn(ans1);
        check.OnClickBtn(ans2);
        check.OnClickBtn(ans3);

        // Inicializa os componentes na class Update
        uptdUI = new UpdateUI();
        uptdUI.InitComponentsUI(question);
    }
}
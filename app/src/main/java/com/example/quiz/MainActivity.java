package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button ans1, ans2, ans3;
    TextView level, question, tip;
    // InitApp init;
    CheckResponse check;
    public ArrayList<Questions> questionsList;

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
        tip = findViewById(R.id.tipQuestion);

        // Instanciando variáveis
        questionsList = new ArrayList<Questions>();

        AddQuestion(); // Adicionando perguntas

        // Obtendo nível
        if (getLevel() == 0) {
            RecordLevel(1);
        }
        level.setText("Level " + getLevel());

        // Atualizando a UI
        if (getLevel() <= questionsList.size()) {
            question.setText(getQuestion(getLevel() - 1).getQuestion());
            ans1.setText(getQuestion(getLevel() - 1).getOption1());
            ans2.setText(getQuestion(getLevel() - 1).getOption2());
            ans3.setText(getQuestion(getLevel() - 1).getOption3());
            tip.setText(getQuestion(getLevel() - 1).getTip());
        } else {
            level.setText("Você venceu !");
            CleanData();
        }

        // Adicionando evento para chamar o Update da UI
        check = new CheckResponse();
        OnClickBtn(ans1);
        OnClickBtn(ans2);
        OnClickBtn(ans3);

        // Buscando dados
        // fetchDB();
    }

    private void UpdateUI(String userRespose) {

        // Transformar em maiuscula depois verificar
        if (userRespose == getQuestion(getLevel() - 1).getAnswer_Nr()) { // check.ConfirmRespose(userRespose)
            RecordLevel(getLevel() + 1);

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

    @Override
    protected void onPause() {
        super.onPause();

        level.setText("Level " + getLevel());
    }

    private void RecordLevel(int level) {
        SharedPreferences preferences = getSharedPreferences("GlobalKey", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("level", level);
        editor.commit();
    }

    private int getLevel() {
        SharedPreferences preferences = getSharedPreferences("GlobalKey", MODE_PRIVATE);
        return preferences.getInt("level", 0);
    }

    private void CleanData() {
        SharedPreferences preferences = getSharedPreferences("GlobalKey", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

    private void AddQuestion() {
        Questions myQuestion = new Questions("Qual a capital do Brasil ?", "Roraima", "Bahia", "Brasilia", "Sua sigla é conhecida como DF", "BRASILIA");
        questionsList.add(myQuestion);
    }

    private Questions getQuestion(int index) {
        return questionsList.get(index);
    }
//    private void fetchDB(){
//        QuizDbHelper dbHelper = new QuizDbHelper(this);
//        questionsList = dbHelper.getAllQuestions();
//    }
}
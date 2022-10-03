package com.example.quiz;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class CheckResponse extends AppCompatActivity {

    public boolean ConfirmRespose(String userRespose)
    {

        MainActivity main = new MainActivity();
        String resp = main.questionsList.get(0).getQuestion();

        if(userRespose == resp)
        {
            return true;
        }
        return false;
    }
}

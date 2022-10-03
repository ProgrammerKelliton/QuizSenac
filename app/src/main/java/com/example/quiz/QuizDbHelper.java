package com.example.quiz;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.quiz.QuizContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {

    private  static  final  String DATABASE_NAME = "GoQuiz";
    private  static  final int DATABASE_VERSION = 1;

    private  SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT," +
                QuestionTable.COLUMN_OPTION1 + " TEXT," +
                QuestionTable.COLUMN_OPTION2 + " TEXT," +
                QuestionTable.COLUMN_OPTION3 + " TEXT," +
                QuestionTable.COLUMN_TIP + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);

        fillQuestionsTable();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int odlVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    private void addQuestios(Questions questions) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION, questions.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1, questions.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2, questions.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3, questions.getOption3());
        cv.put(QuestionTable.COLUMN_TIP, questions.getTip());
        cv.put(QuestionTable.COLUMN_ANSWER_NR, questions.getAnswer_Nr());

        db.insert(QuestionTable.TABLE_NAME, null, cv);

    }
    private void fillQuestionsTable(){
//
//        Questions q1 = new Questions( "Android is what ?", "OS", "Drivers", "Software","WEB", 0 );
//        addQuestios(q1);
//
//        Questions q2 = new Questions( "Unity is used for what", "Game Davelopment", "Movie Making", "Software","WEb", 0 );
//        addQuestios(q2);
//
//        Questions q3 = new Questions( "Ram stands  for", "GUI", "Browser", "Random Access Memory","WEB", 1 );
//        addQuestios(q3);
//
//        Questions q4 = new Questions( "Qual foi o primeiro Presidente do Brasil?", "Deodoro da Fonseca ", "Juscelino Kubitscheck ", "Tancredo Neves","WEB", 1 );
//        addQuestios(q4);
//
//        Questions q5 = new Questions( "Android is what ?", "OS", "Drivers", "Software","WEB", 0 );
//        addQuestios(q5);
//
//        Questions q6 = new Questions( "Android is what ?", "OS", "Drivers", "Software","WEB", 0 );
//        addQuestios(q6);



    }

    @SuppressLint("range")
    public ArrayList<Questions> getAllQuestions(){

        ArrayList<Questions> questionsList = new ArrayList<>();

        db = getReadableDatabase();

        String[] Projection = {
                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_TIP,
                QuestionTable.COLUMN_ANSWER_NR

        };

        Cursor c = db.query(QuestionTable.TABLE_NAME,
                Projection,
                null,
                null,
                null,
                null,
                null
        );

//        if(c.moveToFirst()){
//            do{
//
//                Questions questions = new Questions();
//                questions.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
//                questions.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
//                questions.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
//                questions.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
//                questions.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_TIP)));
//                questions.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
//
//
//                questionsList.add(questions);
//
//            }while (c.moveToNext());
//        }
        c.close();
        return questionsList;
    }
}
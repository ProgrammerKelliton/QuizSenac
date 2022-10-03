package com.example.quiz;

public class Questions {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String tip;
    private String answer_Nr;

    // public  Questions(){}

    public Questions(String question, String option1, String option2, String option3,String tip, String answer_Nr) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.tip = tip;
        this.answer_Nr = answer_Nr;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip= tip;
    }

    public String getAnswer_Nr() {
        return answer_Nr;
    }

    public void setAnswer_Nr(String answer_Nr) {
        this.answer_Nr = answer_Nr;
    }
}

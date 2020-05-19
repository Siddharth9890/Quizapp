package com.example.quizapp;

public class Question {
    private int answerid;
    private boolean answer;

    public Question(int answerid, boolean answer) {
        this.answerid = answerid;
        this.answer = answer;
    }

    public int getAnswerid() {
        return answerid;
    }

    public void setAnswerid(int answerid) {
        this.answerid = answerid;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}

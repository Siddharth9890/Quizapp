package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button falsebtn,truebtn;
private ImageButton nextbtn;
private TextView questiontxt;
private int currentindex=0;
private int current=0;
private Question[] questionbank=new Question[]
        {
                new Question(R.string.question_amendments,false),
                new Question(R.string.question_constitution, true),
                new Question(R.string.question_declaration, true),
                new Question(R.string.question_independence_rights, true),
                new Question(R.string.question_religion, true),
                new Question(R.string.question_government, false),
                new Question(R.string.question_government_feds, false),
                new Question(R.string.question_government_senators, true),
        };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Question question=new Question(R.string.my_question,true);
        falsebtn=findViewById(R.id.falsebtn);
        truebtn=findViewById(R.id.truebtn);
        questiontxt=findViewById(R.id.answer_text);
        nextbtn=findViewById(R.id.nextbtn);
        falsebtn.setOnClickListener(this);//register btns using a common interface
        truebtn.setOnClickListener(this);
        nextbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.falsebtn:
                checkans(false);
                // Toast.makeText(getApplicationContext(),"False",Toast.LENGTH_SHORT).show();
                break;
            case R.id.truebtn:
                checkans(true);
                // Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nextbtn:
                if(current==1) {
                    currentindex = (currentindex + 1) % questionbank.length;
                    questiontxt.setText(questionbank[currentindex].getAnswerid());
                    current=0;
                    break;
                }
                Toast.makeText(getApplicationContext(),"First attempt the question",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void checkans(boolean usercorrect)
    {
        boolean answer=questionbank[currentindex].isAnswer();
        int toastmessageid;
        if(usercorrect==answer)
        {
            toastmessageid=R.string.correct_answer;
        }else
        {
            toastmessageid=R.string.wrong_answer;
        }
        current=1;
        Toast.makeText(getApplicationContext(),toastmessageid,Toast.LENGTH_LONG).show();
    }
}

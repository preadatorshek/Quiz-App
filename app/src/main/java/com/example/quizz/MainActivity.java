package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    Button gobutton;
    TextView question;
    TextView timer;
    TextView count;
    TextView correct;
    int correctlocation;
    ArrayList<Integer> answers = new ArrayList<>();
    int score = 0;
    int counter;
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    public void start(View view) {

        gobutton.setVisibility(View.INVISIBLE);
    }

    public void chooseanswer (View view) {

        if (Integer.toString((Integer) view.getTag()) == Integer.toString(correctlocation)) {

            correct.setText("Correct :)");
            score++;
        } else {
            correct.setText("Wrong :(");
        }
        counter++;

            count.setText(score+"/"+counter);

            answers.clear();
            newquestion();

  new CountDownTimer(30100,1000) {

      @Override
      public void onTick(long l) {

      }

      @Override
      public void onFinish() {

          if (score >= 10) {
              correct.setText("Times Up You Did Great");
          }
          else {
              correct.setText("Times up You need yo improve");
          }
      }
  }.start();

        timer.setText("");
    }



    public void newquestion() {

        Random random = new Random();

        int a = random.nextInt(110);
        int b  = random.nextInt(111);

        question.setText(a+ ":" +b);

         correctlocation = random.nextInt(4);

          int wronganswer = random.nextInt(201);

            for (int i =0; i<4; i++) {

            if (i == correctlocation) {
                answers.add(a+b);
            }
            else
            {
                wronganswer = random.nextInt(200);
            }

            while (wronganswer == a+b) {
                wronganswer = random.nextInt(188);
            }
            answers.add(wronganswer);
        }

        button1.setText(answers.get(0));
         button2.setText(answers.get(1));
          button3.setText(answers.get(2));
           button4.setText(answers.get(3));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = findViewById(R.id.timer);
        count = findViewById(R.id.count);
        correct = findViewById(R.id.correct);

        gobutton = findViewById(R.id.gobutton);
          question = findViewById(R.id.question);
          counter = 0;

         button1 = findViewById(R.id.button0);
          button2 = findViewById(R.id.button1);
           button3 = findViewById(R.id.button2);
            button4 = findViewById(R.id.button3);

              newquestion();
    }
}

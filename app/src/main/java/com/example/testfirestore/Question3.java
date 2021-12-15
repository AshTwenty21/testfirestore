package com.example.testfirestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question3 extends AppCompatActivity {
    public static final String EXTRA_NUMBER3 ="LAIT";
    int lait,number2,number3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        Button button3 = (Button)  findViewById(R.id.button3);
        Button button4 = (Button)  findViewById(R.id.button4);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lait = 10;
                openActivitybbt2();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lait = 0;
                openActivitybbt2();
            }
        });
        Intent intent = getIntent();
        number2 = intent.getIntExtra(Question2.EXTRA_NUMBER2, 0);
        TextView textViewVal = (TextView)  findViewById(R.id.textViewVal);

        textViewVal.setText(""+number2);


    }
    void openActivitybbt2() {
        Intent intent = new Intent(this, Question4.class);
        number3 = number2 + lait;
        intent.putExtra(EXTRA_NUMBER3,number3);
        startActivity(intent);
    }
}
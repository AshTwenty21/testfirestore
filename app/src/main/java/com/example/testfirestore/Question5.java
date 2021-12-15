package com.example.testfirestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Question5 extends AppCompatActivity {
    public static final String EXTRA_NUMBER5 ="GOUT";
    int number4,number5,gout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        Button button7 = (Button)  findViewById(R.id.button7);
        Button button8 = (Button)  findViewById(R.id.button8);
        Button button9 = (Button)  findViewById(R.id.button9);
        Button button10 = (Button)  findViewById(R.id.button10);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gout = 1000;
                openActivitybbt4();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gout = 5000;
                openActivitybbt4();
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gout = 10000;
                openActivitybbt4();
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gout = 20000;
                openActivitybbt4();
            }
        });
        Intent intent = getIntent();
        number4 = intent.getIntExtra(Question4.EXTRA_NUMBER4, 0);
    }
    void openActivitybbt4() {
        Intent intent = new Intent(this, MainActivity.class);
        number5 = number4 + gout;
        intent.putExtra(EXTRA_NUMBER5,number5);
        startActivity(intent);
    }
}
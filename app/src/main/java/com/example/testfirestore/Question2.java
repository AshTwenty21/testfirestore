package com.example.testfirestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Question2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        Intent intent = getIntent();
        String texte = intent.getStringExtra(Question1.EXTRA_TEXT);
        int number = intent.getIntExtra(Question1.EXTRA_NUMBER, 0);

        TextView textView1 = (TextView)  findViewById(R.id.textview1);
        TextView textView2 = (TextView)  findViewById(R.id.textview2);

        textView1.setText(texte);
        textView2.setText(""+number);
    }
}
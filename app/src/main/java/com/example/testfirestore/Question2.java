package com.example.testfirestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question2 extends AppCompatActivity {
    public static final String EXTRA_NUMBER2 ="TEMP";
    int temp,number,number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        Button button = (Button)  findViewById(R.id.button);
        Button button2 = (Button)  findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = 1;
                openActivitybbt();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = 0;
                openActivitybbt();
            }
        });

        Intent intent = getIntent();
        String texte = intent.getStringExtra(Question1.EXTRA_TEXT);
        number = intent.getIntExtra(Question1.EXTRA_NUMBER, 0);

        TextView textView1 = (TextView)  findViewById(R.id.textview1);
        TextView textView2 = (TextView)  findViewById(R.id.textview2);

        textView1.setText(texte);
        textView2.setText(""+number);
    }

    void openActivitybbt() {
        Intent intent = new Intent(this, Question3.class);
        number2 = number + temp;
        intent.putExtra(EXTRA_NUMBER2,number2);
        startActivity(intent);
    }
}
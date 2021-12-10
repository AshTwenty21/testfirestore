package com.example.testfirestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        Button button = (Button)  findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitybbt();
            }
        });

        Intent intent = getIntent();
        String texte = intent.getStringExtra(Question1.EXTRA_TEXT);
        int number = intent.getIntExtra(Question1.EXTRA_NUMBER, 0);

        TextView textView1 = (TextView)  findViewById(R.id.textview1);
        TextView textView2 = (TextView)  findViewById(R.id.textview2);

        textView1.setText(texte);
        textView2.setText(""+number);
    }

    void openActivitybbt() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
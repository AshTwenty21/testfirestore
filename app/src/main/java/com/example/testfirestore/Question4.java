package com.example.testfirestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Question4 extends AppCompatActivity {
    public static final String EXTRA_NUMBER4 ="MACHE";
    int number3,number4,mache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        Button button5 = (Button)  findViewById(R.id.button5);
        Button button6 = (Button)  findViewById(R.id.button6);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mache = 100;
                openActivitybbt3();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mache = 0;
                openActivitybbt3();
            }
        });
        Intent intent = getIntent();
        number3 = intent.getIntExtra(Question3.EXTRA_NUMBER3, 0);
    }
    void openActivitybbt3() {
        Intent intent = new Intent(this, Question5.class);
        number4 = number3 + mache;
        intent.putExtra(EXTRA_NUMBER4,number4);
        startActivity(intent);
    }
}
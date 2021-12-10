package com.example.testfirestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Question1 extends AppCompatActivity {

    public static final String EXTRA_TEXT ="com.example.application.testfirestore.EXTRA_TEXT";
    public static final String EXTRA_NUMBER ="com.example.application.testfirestore.EXTRA_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        Button button = (Button)  findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }
    public void openActivity2(){
        EditText editText1 = (EditText) findViewById(R.id.edittext1);
        String texte = editText1.getText().toString();

        //EditText editText2 = (EditText) findViewById(R.id.edittext2);
        //int number = Integer.parseInt(editText1.getText().toString());


        Intent intent = new Intent(this, Question2.class);
        intent.putExtra(EXTRA_TEXT, texte);
        //intent.putExtra(EXTRA_NUMBER, number);
        startActivity(intent);
    }
}
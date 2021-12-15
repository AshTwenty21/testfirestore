package com.example.testfirestore;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edit text
    private EditText NameEdt, TasteEdt, PriceEdt;

    // creating variable for button
    private Button submitCourseBtn, viewCoursesBtn;

    // creating a strings for storing
    // our values from edittext fields.
    private String Name, Price, Taste;

    // creating a variable
    // for firebasefirestore.
    private FirebaseFirestore db;

    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting our instance
        // from Firebase Firestore.
        db = FirebaseFirestore.getInstance();

        // initializing our edittext and buttons
        NameEdt = findViewById(R.id.idEdtName);
        PriceEdt = findViewById(R.id.idEdtPrice);
        TasteEdt = findViewById(R.id.idEdtTaste);
        submitCourseBtn = findViewById(R.id.idBtnSubmitCourse);
        viewCoursesBtn = findViewById(R.id.idBtnViewCourses);

        // adding onclick listener to view data in new activity
        viewCoursesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity on button click
                Intent i = new Intent(MainActivity.this,CourseDetails.class);
                startActivity(i);
            }
        });

        // adding on click listener for button
        submitCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting data from edittext fields.
                Name = NameEdt.getText().toString();
                Price = PriceEdt.getText().toString();
                Taste = TasteEdt.getText().toString();

                // validating the text fields if empty or not.
                if (TextUtils.isEmpty(Name)) {
                    NameEdt.setError("Please enter Course Name");
                } else if (TextUtils.isEmpty(Price)) {
                    PriceEdt.setError("Please enter Course Description");
                } else if (TextUtils.isEmpty(Taste)) {
                    TasteEdt.setError("Please enter Course Duration");
                } else {
                    // calling method to add data to Firebase Firestore.
                    addDataToFirestore(Name, Price, Taste);
                }
            }
        });
       Intent intent = getIntent();
        number = intent.getIntExtra(Question5.EXTRA_NUMBER5, 0);

        TextView textViewTotal = (TextView)  findViewById(R.id.textViewTotal);
        textViewTotal.setText(""+number);
    }

    private void addDataToFirestore(String Name, String Price, String Taste) {

        // creating a collection reference
        // for our Firebase Firetore database.
        CollectionReference dbCourses = db.collection("BbtSugar");

        // adding our data to our courses object class.
        Courses courses = new Courses(Name, Price, Taste);

        // below method is use to add data to Firebase Firestore.
        dbCourses.add(courses).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                // after the data addition is successful
                // we are displaying a success toast message.
                Toast.makeText(MainActivity.this, "Your Course has been added to Firebase Firestore", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // this method is called when the data addition process is failed.
                // displaying a toast message when data addition is failed.
                Toast.makeText(MainActivity.this, "Fail to add course \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

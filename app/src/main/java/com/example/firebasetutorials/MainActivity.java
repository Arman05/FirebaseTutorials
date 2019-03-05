package com.example.firebasetutorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button mFirebaseBtn;
    private DatabaseReference mDatabase;

    //Git commit testing

    private EditText mNameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseBtn = (Button) findViewById(R.id.firebase_btn);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //mDatabase = FirebaseDatabase.getInstance().getReference().child("User_01");

        mNameField = (EditText) findViewById(R.id.name_field);

        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1 - Create child in root object
                //2- Assign some value to the child object

                String name = mNameField.getText().toString().trim();

                mDatabase.child("Name").setValue(name);

                mDatabase.push().setValue(name);

            }
        });
    }
}

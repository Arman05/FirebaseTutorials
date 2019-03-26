package com.example.firebasetutorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    private ListView mEventList;


    public class Event {

        String name;
        String note;
        Date date;

        public Event(String name,int day, int month,int year, int hour, int min) {

            this.name = name;
            Calendar calendar = Calendar.getInstance();
            calendar.set(year+2000,month-1,day,hour,min);
            this.date = calendar.getTime();
            Log.i("DATE",this.date.toString());
        }

        public Event(String name,int day, int month,int year, int hour, int min,String note) {

            this.name = name;
            this.note = note;
            Calendar calendar = Calendar.getInstance();
            calendar.set(year+2000,month-1,day,hour,min);
            this.date = calendar.getTime();
            Log.i("DATE",this.date.toString());
        }

    }


    public void click(View view){

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mEventList = (ListView)  findViewById(R.id.eventList);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

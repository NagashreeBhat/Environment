package com.example.environmentalchanges.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.environmentalchanges.R;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;

public class Habits extends AppCompatActivity {


    private TextView myTextview1, myTextview2, myTextview3, myTextview4, myTextview5;
    private RadioGroup mycheck1, mycheck2, mycheck3, mycheck4;
    RadioButton rad1, rad2, rad3, rad4, rad5, rad6, rad7, rad8;
    private Button mbtn1;
    private  String myStringData1, myStringData2, myStringData3, myStringData4, myStringData5, myStringData6, myStringData7, myStringData8, myStringData9, myStringData10, myStringData11, myStringData12;

    Firebase myFirebase;
    private DatabaseReference mDatabase;
    String radio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habits);


        myTextview1 = (TextView) findViewById(R.id.textView1);
        mycheck1 = (RadioGroup) findViewById(R.id.radio1);
//        mycheck1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                rad1 = mycheck1.findViewById(checkedId);
//
//                switch (checkedId){
//                    case R.id.radioYes:
//                        radio = rad1.getText().toString();
//                    case R.id.radioNo:
//                        radio = rad2.getText().toString();
//                    default:
//                }
//            }
//        });


        myTextview2 = (TextView) findViewById(R.id.textView2);
        mycheck2 = (RadioGroup) findViewById(R.id.radio2);

        myTextview3 = (TextView) findViewById(R.id.textView3);
        mycheck3 = (RadioGroup) findViewById(R.id.radio3);

        myTextview4 = (TextView) findViewById(R.id.textView4);
        mycheck4 = (RadioGroup) findViewById(R.id.radio4);



        mbtn1 = (Button) findViewById(R.id.button1);
        //mDatabase = FirebaseDatabase.getInstance().getReference();

        Firebase.setAndroidContext(Habits.this);




        String DeviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        myFirebase = new Firebase("https://environmentfootprint-1a3c2.firebaseio.com/Users" + DeviceID);
        mbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                myStringData1 = myTextview1.getText().toString().trim();
                Integer id = mycheck1.getId();
                String text = id.toString();
                myStringData2 = text;

//                myStringData2 = String.valueOf(mycheck1.getId());


                myStringData3 = myTextview2.getText().toString();
                myStringData4 = String.valueOf(mycheck2.getId());



                myStringData5 = myTextview3.getText().toString();
                myStringData6 = String.valueOf(mycheck3.getId());



                myStringData7 = myTextview4.getText().toString();
                myStringData8 = String.valueOf(mycheck4.getId());
//                myStringData11 = mycheck4.getId().toString();




                HashMap<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("Question 1", myStringData1);
                dataMap.put("Answer 1", myStringData2);
                dataMap.put("Question 2", myStringData3);
                dataMap.put("Answer 2", myStringData4);
                dataMap.put("Question 3", myStringData5);
                dataMap.put("Answer 3", myStringData6);
                dataMap.put("Question 4", myStringData7);
                dataMap.put("Answer 4", myStringData8);
                Firebase myNewChild = myFirebase.child("Habits");
                myNewChild.setValue(dataMap);






//                Firebase myNewChild1 = myFirebase.child(myStringData2).child(myStringData3);
//                myNewChild1.setValue(myStringData1);






                Intent intent = new Intent(Habits.this, EnvirontmentFootprint.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });


        Button mbtn = (Button) findViewById(R.id.button2);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancel = new Intent(Habits.this, EnvirontmentFootprint.class);
                cancel.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(cancel);
                finish();

            }
        });
    }
}

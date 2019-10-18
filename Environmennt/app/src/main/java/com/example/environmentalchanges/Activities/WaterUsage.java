package com.example.environmentalchanges.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.environmentalchanges.R;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;

public class WaterUsage extends AppCompatActivity {

    private TextView myTextview5, myTextview6, myTextview7, myTextview8;
    private RadioGroup mycheck5, mycheck6, mycheck7, mycheck8;
    private Button mbtn1;
    private  String myStringData9, myStringData10, myStringData11, myStringData12,myStringData13, myStringData14, myStringData15, myStringData16 ;

    Firebase myFirebasewater;
    private DatabaseReference mDatabase;
    String radio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_usage);


        myTextview5 = (TextView) findViewById(R.id.textView1);
        mycheck5 = (RadioGroup) findViewById(R.id.radio1);
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


        myTextview6 = (TextView) findViewById(R.id.textView2);
        mycheck6 = (RadioGroup) findViewById(R.id.radio2);

        myTextview7 = (TextView) findViewById(R.id.textView3);
        mycheck7 = (RadioGroup) findViewById(R.id.radio3);

        myTextview8 = (TextView) findViewById(R.id.textView4);
        mycheck8 = (RadioGroup) findViewById(R.id.radio4);



        mbtn1 = (Button) findViewById(R.id.button1);
        //mDatabase = FirebaseDatabase.getInstance().getReference();

        Firebase.setAndroidContext(WaterUsage.this);




        String DeviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        myFirebasewater = new Firebase("https://environmentfootprint-1a3c2.firebaseio.com/Users" + DeviceID);
        mbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                myStringData9 = myTextview5.getText().toString().trim();
                Integer id = mycheck5.getId();
                String text = id.toString();
                myStringData10 = text;

//                myStringData2 = String.valueOf(mycheck1.getId());


                myStringData11 = myTextview6.getText().toString();
                myStringData12 = String.valueOf(mycheck6.getId());



                myStringData13 = myTextview7.getText().toString();
                myStringData14 = String.valueOf(mycheck7.getId());



                myStringData15 = myTextview8.getText().toString();
                myStringData16 = String.valueOf(mycheck8.getId());
//                myStringData11 = mycheck4.getId().toString();




                HashMap<String, String> dataMap1 = new HashMap<String, String>();
                dataMap1.put("Question 1", myStringData9);
                dataMap1.put("Answer 1", myStringData10);
                dataMap1.put("Question 2", myStringData11);
                dataMap1.put("Answer 2", myStringData12);
                dataMap1.put("Question 3", myStringData13);
                dataMap1.put("Answer 3", myStringData14);
                dataMap1.put("Question 4", myStringData15);
                dataMap1.put("Answer 4", myStringData16);
                Firebase myNewChild = myFirebasewater.child("Water Usage");
                myNewChild.setValue(dataMap1);






//                Firebase myNewChild1 = myFirebase.child(myStringData2).child(myStringData3);
//                myNewChild1.setValue(myStringData1);






                Intent intent = new Intent(WaterUsage.this, EnvirontmentFootprint.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });


        Button mbtn = (Button) findViewById(R.id.button2);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancel = new Intent(WaterUsage.this, EnvirontmentFootprint.class);
                cancel.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(cancel);
                finish();

            }
        });
    }
}

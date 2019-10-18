package com.example.environmentalchanges.Activities;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.environmentalchanges.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity implements View.OnClickListener{

EditText editUsername,editEmail,editPassword;
Button signup;

FirebaseAuth myFirebaseAuth;
String myEMail, myPassword, myUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        myFirebaseAuth = FirebaseAuth.getInstance();

        if(myFirebaseAuth.getCurrentUser()!= null){
            Intent homeIntent = new Intent(LoginPage.this, ProfilePage.class);
            startActivity(homeIntent);
            finish();
        }

        editUsername = findViewById(R.id.editUserName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        signup = findViewById(R.id.signup);
        signup.setOnClickListener(this);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myEMail = editEmail.getText().toString();
                myPassword = editPassword.getText().toString();
                myUsername = editUsername.getText().toString();


                CreateNewUser();
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.signup:
                Intent signup = new Intent(this, ProfilePage.class);
                signup.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(signup);
                finish();
                break;
        }

    }

    private  void CreateNewUser() {
        myFirebaseAuth.createUserWithEmailAndPassword(myEMail, myPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Intent homeIntent = new Intent(LoginPage.this, ProfilePage.class);
                    startActivity(homeIntent);
                    finish();
                }
                else {
                    Toast.makeText(LoginPage.this, "Error is "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

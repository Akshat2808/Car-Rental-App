package com.example.carrentals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    private Button callSignUp,login_btn;
    private ImageView image;
    TextView logoText,sloganText;
    TextInputLayout username,password,phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This Line will hide the status bar from the screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);
        //Hooks
        callSignUp = findViewById(R.id.button3);
        image = findViewById(R.id.logo_image);
//        logoText = findViewById(R.id.textView3);
//        sloganText = findViewById(R.id.slogan_name);
        username = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPassword);
        login_btn = findViewById(R.id.button2);



        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, UserProfile.class);
                startActivity(intent);
            }
        });
    }

    private Boolean validateUsername() {
        String val = username.getEditText().getText().toString();

        if (val.isEmpty()) {
            username.setError("Field cannot be empty");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatePassword(){
        String val =  password.getEditText().getText().toString();
        if (val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        }

        else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }


    public void loginUser(View view){
        //Validate Login Info
        if(!validateUsername() | !validatePassword()){
            return;
        }
        else{
//                        System.out.println("password is correct");
            isUser();
        }
    }

    private void isUser() {
       final String userEnteredUsername = username.getEditText().getText().toString().trim();
       final String userEnteredPassword = password.getEditText().getText().toString().trim();


//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
//        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);

//        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

//                if(dataSnapshot.exists()){
//                    username.setError(null);
//                    username.setErrorEnabled(false);
//                    String phoneNo = dataSnapshot.getValue().toString().substring(1, 11);
//                    String passwordFromDB = dataSnapshot.child(phoneNo).child("password").getValue(String.class);

//                    if (passwordFromDB.equals(userEnteredPassword)){
//                        username.setError(null);
//                        username.setErrorEnabled(false);
//
//                        String nameFromDB = dataSnapshot.child(phoneNo).child("name").getValue(String.class);
//                        String usernameFromDB = dataSnapshot.child(phoneNo).child("username").getValue(String.class);
//                        String emailFromDB = dataSnapshot.child(phoneNo).child("email").getValue(String.class);
//
//
//                        Intent intent = new Intent(getApplicationContext(),UserProfile.class);
//                        intent.putExtra("name",nameFromDB);
//                        intent.putExtra("username",usernameFromDB);
//                        intent.putExtra("email",emailFromDB);
//                        intent.putExtra("phoneNo",phoneNo);
//                        intent.putExtra("password",passwordFromDB);

//                        startActivity(intent);
//                    }
//                    else{
//                        password.setError("Wrong Password");
//                        password.requestFocus();
//                    }
//
//                }
//                else{
//                    username.setError("No such User exist");
//                    username.requestFocus();
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {

//            }
//        });

    }



}
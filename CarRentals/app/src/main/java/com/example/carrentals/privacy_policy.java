package com.example.carrentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class privacy_policy extends AppCompatActivity {

    public ImageButton rzp_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy_policy);

        rzp_back = (ImageButton) findViewById(R.id.back_rzp_privacy);
        rzp_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(privacy_policy.this, razorpay.class);
                startActivity(intent);
            }
        });
    }
}
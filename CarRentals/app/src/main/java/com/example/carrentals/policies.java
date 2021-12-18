package com.example.carrentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class policies extends AppCompatActivity {

    public ImageButton back_policies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.policies);

        back_policies = (ImageButton) findViewById(R.id.back_arrow_privacy_policy);
        back_policies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(policies.this, pickup_address.class);
                startActivity(intent);
            }
        });
    }
}
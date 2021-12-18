package com.example.carrentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class help_support extends AppCompatActivity {

    public ImageButton back_help_support;

    private Spinner spinner_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_support);

        back_help_support = (ImageButton) findViewById(R.id.back_arrow_help_support);
        back_help_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(help_support.this, pickup_address.class);
                startActivity(intent);
            }
        });

        spinner_help = findViewById(R.id.spinner_help_support);

        String[] help_support = getResources().getStringArray(R.array.q_1);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, help_support);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_help.setAdapter(adapter);
    }
}
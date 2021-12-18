package com.example.carrentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class popup extends AppCompatActivity {

    public Button popup_logout;
    public Button popup_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);

        popup_continue = (Button) findViewById(R.id.popup_continue);
        popup_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(popup.this, select_city.class);
                startActivity(intent);
            }
        });

        popup_logout = (Button) findViewById(R.id.popup_logout);
        popup_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(popup.this, login.class);
                startActivity(intent);
            }
        });
    }
}
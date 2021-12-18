package com.example.carrentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CarDetailsActivity extends AppCompatActivity {

    Toolbar carDetailsActionBar;
    TextView actionBarTitle;
    TextView rentRate;
    TextView totalRent;
    Button proceedToPay;
    ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_details);
        carDetailsActionBar = findViewById(R.id.car_details_action_bar);
        setSupportActionBar(carDetailsActionBar);
        Intent intent = getIntent();
        String title = intent.getStringExtra("carName");
        String temp = intent.getStringExtra("carPrice");
        String price = temp.substring(0, temp.indexOf("/"));
        String priceValue = price.substring(price.indexOf("₹")+1);
        String value = priceValue.replace(",", "");
        int rent = Integer.parseInt(value);
        backArrow = findViewById(R.id.back_arrow);

        actionBarTitle = findViewById(R.id.car_details_heading);
        rentRate = findViewById(R.id.rent_price_text_view);
        totalRent = findViewById(R.id.total_rent_price_text_view);
        proceedToPay = findViewById(R.id.proceed_to_pay_button);
        actionBarTitle.setText(title);
        rentRate.setText(price);
        totalRent.setText("₹"+(rent+1000));
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), car_selection_menu.class);
                startActivity(intent2);
            }
        });
        proceedToPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent1 = new Intent(getApplicationContext(), razorpay.class);
            startActivity(intent1);
            }
        });
    }
}
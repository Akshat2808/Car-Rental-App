package com.example.carrentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class car_selection_menu extends AppCompatActivity implements MyRecyclerViewAdapter.OnCarListener {

    Toolbar carSelectionActionBar;
    RecyclerView carSelectionMenu;
    List<ViewItemModel> myCarList;
    MyRecyclerViewAdapter myRecyclerViewAdapter;
    LinearLayoutManager linearLayout;
    ImageButton backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_selection_menu);
        carSelectionActionBar = findViewById(R.id.car_selection_action_bar);
        setSupportActionBar(carSelectionActionBar);
        setData();
        setRecyclerView();
        backArrow = findViewById(R.id.back_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), pickup_address.class);
                startActivity(intent);
            }
        });
    }

    private void setRecyclerView(){
        carSelectionMenu = findViewById(R.id.recycler_view);
        linearLayout = new LinearLayoutManager(this);
        carSelectionMenu.setLayoutManager(linearLayout);
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(myCarList, this);
        carSelectionMenu.setAdapter(myRecyclerViewAdapter);
        myRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void setData(){
        myCarList = new ArrayList<>();
        myCarList.add(new ViewItemModel(R.drawable.tata_nexon, R.id.divider2, R.id.divider3, "Tata Nexon",
                "Manual  •  Petrol  •  5 seats", "5.0  •  42,523 kms driven",
                "₹19,000/month"));
        myCarList.add(new ViewItemModel(R.drawable.baleno_reduced, R.id.divider2, R.id.divider3
                , "Suzuki Baleno", "Manual  •  Diesel  •  4 seats", "4.7  •  50,841 kms driven",
                "₹19,000/month"));
        myCarList.add(new ViewItemModel(R.drawable.creta_reduced, R.id.divider2, R.id.divider3,
                "Hyundai Creta","Manual  •  Diesel  •  6 seats",
                "4.4  •  19,101 kms driven", "₹19,000/month"));
        myCarList.add(new ViewItemModel(R.drawable.xuv_500, R.id.divider2, R.id.divider3,
                "Mahindra XUV 500","Manual  •  Diesel  •  7 seats",
                "4.6  •  32,905 kms driven", "₹19,000/month"));
    }

    @Override
    public void onCarClick(int position) {
        Intent intent = new Intent(getApplicationContext(), CarDetailsActivity.class);
        intent.putExtra("carName", myCarList.get(position).getHeading());
        intent.putExtra("carPrice", myCarList.get(position).getPrice());
        startActivity(intent);
    }
}
package com.example.carrentals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.navigation.NavigationView;

import java.util.Calendar;
import java.util.TimeZone;

public class pickup_address extends AppCompatActivity {

    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    public Button find_cars;
    public ImageButton back_pickup;
//    public Button menu_logout;

    public ImageView menu_pickup;

//    Dialog dialog1;

    private Spinner spinner_change_route;

    private Button select_date;
    private TextView selected_date_range;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickup_address);

//        dialog1 = new Dialog(this);

//        menu_logout = (Button) findViewById(R.id.menu_logout);
//        menu_logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPopupWindow1();
//            }
//        });

        menu_pickup = (ImageView) findViewById(R.id.dropdown_menu_pickup);
        menu_pickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pickup_address.this, pickup_address.class);
                startActivity(intent);
            }
        });

        back_pickup = (ImageButton) findViewById(R.id.back_pickup);
        back_pickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pickup_address.this, select_city.class);
                startActivity(intent);
            }
        });

        find_cars = (Button) findViewById(R.id.pickup_find_cars);
        find_cars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pickup_address.this, car_selection_menu.class);
                startActivity(intent);
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            Fragment temp;
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.menu_policies:
                        Toast.makeText(getApplicationContext(), "Policies", Toast.LENGTH_LONG).show();
                        Intent intent1 = new Intent(pickup_address.this, policies.class);
                        startActivity(intent1);
                        temp = new PoliciesFragment();
                        break;

                    case R.id.menu_change_city:
                        Toast.makeText(getApplicationContext(), "Change City", Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent(pickup_address.this, select_city.class);
                        startActivity(intent2);
                        temp = new SelectCityFragment();
                        break;

                    case R.id.menu_help_support:
                        Toast.makeText(getApplicationContext(), "Help & Support", Toast.LENGTH_LONG).show();
                        Intent intent3 = new Intent(pickup_address.this, help_support.class);
                        startActivity(intent3);
                        temp = new HelpSupportFragment();
                        break;

                    case R.id.menu_logout:
                        Toast.makeText(getApplicationContext(), "Log-Out", Toast.LENGTH_LONG).show();
                        Intent intent4 = new Intent(pickup_address.this, popup.class);
                        startActivity(intent4);
//                        temp = new LogoutFragment();
                        break;

                    case R.id.menu_profile:
                        Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_LONG).show();
                        Intent intent5 = new Intent(pickup_address.this, UserProfile.class);
                        startActivity(intent5);
                        temp = new UserProfileFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, temp).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        spinner_change_route = findViewById(R.id.spinner_route);

        String[] change_route = getResources().getStringArray(R.array.change_route);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, change_route);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_change_route.setAdapter(adapter);

        select_date = findViewById(R.id.pickup_dates);
        selected_date_range = findViewById(R.id.txt_date_range);

        MaterialDatePicker datePicker = MaterialDatePicker.Builder.dateRangePicker().setSelection(Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(), MaterialDatePicker.todayInUtcMilliseconds())).build();
        select_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.show(getSupportFragmentManager(), "Material_Range");
                datePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        selected_date_range.setText("Selected Date Range  :  " + datePicker.getHeaderText());
                    }
                });
            }
        });



//        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
//            @Override
//            public void onPositiveButtonClick(Object selection) {
//                selected_date_range.setText("Selected Date Range : " + selection);
//            }
//        });
    }

//    private void openPopupWindow1() {
//        dialog1.setContentView(R.layout.popup);
//        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        Button popup_continue = dialog1.findViewById(R.id.popup_continue);
//        Button popup_logout = dialog1.findViewById(R.id.popup_logout);
//
//        popup_continue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog1.dismiss();
//            }
//        });
//
//        popup_logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(pickup_address.this, login.class);
//                startActivity(intent);
//            }
//        });
//
//        dialog1.show();
//    }
}
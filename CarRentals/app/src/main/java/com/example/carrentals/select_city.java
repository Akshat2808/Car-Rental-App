package com.example.carrentals;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class select_city extends AppCompatActivity {

    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    public ImageButton back_city_selection;
    public ImageButton vadodara;
    public ImageButton delhi;
    public ImageButton chennai;
    public ImageButton mumbai;
    public Button indore;
    public Button mysore;
    public Button goa;
    public Button patna;
    public Button ahmedabad;

    SearchView mySearchView;
    ListView myListView;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    Dialog dialog;

//    private AlertDialog.Builder dialogueBuilder;
//    private AlertDialog dialog;
//    private Button popup_continue, popup_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_city);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dialog = new Dialog(this);

        back_city_selection = (ImageButton) findViewById(R.id.back_arrow_city_selection);
        back_city_selection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPopupWindow();
            }
        });

        vadodara = (ImageButton) findViewById(R.id.vadodara_button);
        vadodara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Vadodara selected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(select_city.this, pickup_address.class);
                startActivity(intent);
            }
        });

        delhi = (ImageButton) findViewById(R.id.delhi_button);
        delhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Delhi NCR selected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(select_city.this, pickup_address.class);
                startActivity(intent);
            }
        });

        chennai = (ImageButton) findViewById(R.id.chennai_button);
        chennai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Chennai selected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(select_city.this, pickup_address.class);
                startActivity(intent);
            }
        });

        mumbai = (ImageButton) findViewById(R.id.mumbai_button);
        mumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Mumbai selected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(select_city.this, pickup_address.class);
                startActivity(intent);
            }
        });

        indore = (Button) findViewById(R.id.indore_button);
        indore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Indore selected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(select_city.this, pickup_address.class);
                startActivity(intent);
            }
        });

        mysore = (Button) findViewById(R.id.mysore_button);
        mysore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Mysore selected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(select_city.this, pickup_address.class);
                startActivity(intent);
            }
        });

        goa = (Button) findViewById(R.id.goa_button);
        goa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Goa selected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(select_city.this, pickup_address.class);
                startActivity(intent);
            }
        });

        patna = (Button) findViewById(R.id.patna_button);
        patna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Patna selected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(select_city.this, pickup_address.class);
                startActivity(intent);
            }
        });

        ahmedabad = (Button) findViewById(R.id.ahmedabad_button);
        ahmedabad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Ahmedabad selected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(select_city.this, pickup_address.class);
                startActivity(intent);
            }
        });

        mySearchView = (SearchView) findViewById(R.id.search_text);
        myListView = (ListView) findViewById(R.id.list_view);

        list = new ArrayList<String>();

        list.add("Vadodara");
        list.add("Delhi");
        list.add("Mumbai");
        list.add("Chennai");
        list.add("Indore");
        list.add("Mysore");
        list.add("Goa");
        list.add("Patna");
        list.add("Ahmedabad");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        myListView.setAdapter(adapter);
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                adapter.getFilter().filter(s);
                return false;
            }
        });
    }

    private void openPopupWindow() {
        dialog.setContentView(R.layout.popup);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button popup_continue = dialog.findViewById(R.id.popup_continue);
        Button popup_logout = dialog.findViewById(R.id.popup_logout);

        popup_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        popup_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(select_city.this, login.class);
                startActivity(intent);
            }
        });

        dialog.show();
    }



//    public void popup_dialogue(){
//        dialogueBuilder = new AlertDialog.Builder(this);
//        final View logoutPopupView = getLayoutInflater().inflate(R.layout.popup, null);
//
//        popup_continue = (Button) logoutPopupView.findViewById(R.id.popup_continue);
//        popup_logout = (Button) logoutPopupView.findViewById(R.id.popup_logout);
//
//        dialogueBuilder.setView(logoutPopupView);
//        dialog = dialogueBuilder.create();
//        dialog.show();
//
//        popup_continue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
//        popup_logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//    }
}
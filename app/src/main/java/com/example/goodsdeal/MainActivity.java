package com.example.goodsdeal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting the shared preferences
        @SuppressLint("WrongConstant") SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_APPEND);
        //getting the user id and password and the type of user
        String uid = sh.getString("sid", "");
        String password = sh.getString("password", "");
        String type = sh.getString("type", "");
        //checking if there are any passwords and id stored in the shared preference
        if(uid.equals("") || password.equals("") || type.equals("")) {
            //if no launching the Login activity
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        else {
            //if yes launching the MainActivity
            Intent intent;
            if(type.equals("dealer")) {
                //if user type is dealer
                intent = new Intent(MainActivity.this, DealerDashboard.class);
            }
            else {
                //else the user is a driver
                intent = new Intent(MainActivity.this, DriverDashboard.class);
            }
            //starting the activity
            startActivity(intent);
        }
    }
}
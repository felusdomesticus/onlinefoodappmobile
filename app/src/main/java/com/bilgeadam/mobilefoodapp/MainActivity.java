package com.bilgeadam.mobilefoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bilgeadam.mobilefoodapp.activity.MealMenuActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void showMealMenuActivity(View view) {
        Intent intent = new Intent(this, MealMenuActivity.class);
        startActivity(intent);
    }
}

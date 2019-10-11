package com.bilgeadam.mobilefoodapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bilgeadam.mobilefoodapp.R;
import com.bilgeadam.mobilefoodapp.adapter.MealListRecyclerAdapter;
import com.bilgeadam.mobilefoodapp.data.Meal;

import java.util.ArrayList;

public class MealMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_menu);

        //meal list
        ArrayList<Meal> mealList = new ArrayList<>();
        /*mealList.add(new Meal("txt","Mantı","desc"));
        mealList.add(new Meal("txt","Çorba","desc"));
        mealList.add(new Meal("txt","Kavurma","desc"));*/

        //yemek fotolarını değiştir
        // https://i4.hurimg.com/i/hurriyet/75/1500x844/5cdfce0667b0a90adcf9aec5.jpg
        // https://i4.hurimg.com/i/hurriyet/75/1500x844/5d95ed0ac03c0e1c5093199e.jpg
        // https://i4.hurimg.com/i/hurriyet/75/750x422/5d4fca332269a20f5c723a58.jpg
        mealList.add(new Meal("https://i4.hurimg.com/i/hurriyet/75/1500x844/5cdfce0667b0a90adcf9aec5.jpg", "Mantı", "desc"));
        mealList.add(new Meal("https://i4.hurimg.com/i/hurriyet/75/1500x844/5d95ed0ac03c0e1c5093199e.jpg", "Çorba", "desc"));
        mealList.add(new Meal("https://cdn.yemek.com/mncrop/313/280/uploads/2016/09/sac-kavurma-ytk-site.jpg", "Kavurma", "desc"));

        //listview
        /*final ListView listview = findViewById(R.id.listview);
        final MealListViewAdapter adapter = new MealListViewAdapter(this, mealList);
        listview.setAdapter(adapter);*/

        //recyclerview
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        RecyclerView mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        MealListRecyclerAdapter mMealAdapter = new MealListRecyclerAdapter(this, mealList);
        mRecyclerView.setAdapter(mMealAdapter);
    }
}

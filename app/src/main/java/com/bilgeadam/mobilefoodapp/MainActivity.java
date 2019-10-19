package com.bilgeadam.mobilefoodapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bilgeadam.mobilefoodapp.activity.MealMenuActivity;
import com.bilgeadam.mobilefoodapp.dto.JwtTokenRequest;
import com.bilgeadam.mobilefoodapp.dto.JwtTokenResponse;
import com.bilgeadam.mobilefoodapp.service.AuthenticateService;
import com.bilgeadam.mobilefoodapp.utililty.RetrofitClient;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void showMealMenuActivity(View view) {
        Intent intent = new Intent(this, MealMenuActivity.class);
        startActivity(intent);
        authenticate();
    }



    private void authenticate() {
        AuthenticateService authenticateService = RetrofitClient.getRetrofitInstance(this).create(AuthenticateService.class);
        authenticateService.authenticate(new JwtTokenRequest("mesutcan","123")).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String responseString = response.body().string();
                    JwtTokenResponse jwtTokenResponse = new ObjectMapper().readValue(responseString, JwtTokenResponse.class);
                    SharedPreferences sharedPref = getSharedPreferences(
                            getString(R.string.preference_file_key), Context.MODE_PRIVATE);
                    sharedPref.edit().putString("TOKEN", jwtTokenResponse.getToken()).apply();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}

package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String password = prefs.getString(getResources().getString(R.string.key_password), null);
        Class activity;
        if(password == null) {
            activity = SetPasswordActivity.class;
        } else {
            activity = EnterPassActivity.class;
        }
        Intent intent = new Intent(SplashActivity.this, activity);
        startActivity(intent);
        finish();
    }
}
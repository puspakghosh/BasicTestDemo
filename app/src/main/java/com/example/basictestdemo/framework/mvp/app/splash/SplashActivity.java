package com.example.basictestdemo.framework.mvp.app.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basictestdemo.R;
import com.example.basictestdemo.framework.mvp.app.login.LoginActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // A 2-second delay before moving to the next screen
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // Navigate to LoginActivity
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish(); // Prevents user from returning to the splash screen
        }, 2000);
    }
}


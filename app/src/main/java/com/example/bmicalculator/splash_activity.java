package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;

public class splash_activity extends AppCompatActivity {

    private ImageView logoSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

         ImageView logoSplash;

        logoSplash = findViewById(R.id.logoSplash);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_splash);
        logoSplash.startAnimation(animation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash_activity.this,MainActivity.class);
                startActivity(intent);
            }
        },6000);
    }
}
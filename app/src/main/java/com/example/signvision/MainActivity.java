package com.example.signvision;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1900;

    Animation bottomAnimation;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        imageView = findViewById(R.id.Circle);

        imageView.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent howToUseIntent = new Intent(MainActivity.this, HowToUse.class);
                startActivity(howToUseIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
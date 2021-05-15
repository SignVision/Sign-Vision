package com.example.signvision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void onSignToTextClicked(View view) {
        Intent SignToTextIntent = new Intent(HomeActivity.this, SignLanguagetoText.class);
        startActivity(SignToTextIntent);


    }
    public void onSpeechToSignClicked(View view) {
        Intent SpeechToSignIntent = new Intent(HomeActivity.this, SpeechToSign.class);
        startActivity(SpeechToSignIntent);


    }
    public void onTextToSignClicked(View view) {
        Intent TextToSignIntent = new Intent(HomeActivity.this, TextToSign.class);
        startActivity(TextToSignIntent);


    }
}
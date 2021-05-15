package com.example.signvision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SpeechToSign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_to_text);
    }

    public void BacktoHomePage(View view) {
        Intent SpeechToSignIntent = new Intent(SpeechToSign.this, HomeActivity.class);
        startActivity(SpeechToSignIntent);


    }
}
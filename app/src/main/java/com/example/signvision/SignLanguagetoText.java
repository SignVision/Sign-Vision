package com.example.signvision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignLanguagetoText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_languageto_text);
    }

    public void BacktoHomePage(View view) {
        Intent HomeIntent = new Intent(SignLanguagetoText.this, HomeActivity.class);
        startActivity(HomeIntent);


    }
}
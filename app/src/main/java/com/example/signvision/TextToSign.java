package com.example.signvision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;

public class TextToSign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_sign);
    }

    public void onTranslateClicked(View view) {
        EditText text = (EditText) findViewById(R.id.inputField);
        String value = text.getText().toString();
        for(char c:value.toCharArray()){


        }


    }

    public void BacktoHomePage(View view) {
        Intent HomeIntent = new Intent(TextToSign.this, HomeActivity.class);
        startActivity(HomeIntent);

    }
}
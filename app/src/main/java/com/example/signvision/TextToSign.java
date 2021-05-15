package com.example.signvision;

import androidx.appcompat.app.AppCompatActivity;

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
        EditText text = (EditText)findViewById(R.id.inputField);
        String value = text.getText().toString();


    }
}
package com.example.signvision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.ImageView;

import static com.example.signvision.SignLanguage.letterToSign;

public class TextToSign extends AppCompatActivity {
    int curIndex = 0;
    String text="";
    ImageView signImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_sign);
        signImage = (ImageView) findViewById(R.id.Sign_Image);
    }



    public void onTranslateClicked(View view) {
        EditText editText = (EditText) findViewById(R.id.inputField);
        text = editText.getText().toString();
        updateSign();


    }
    void updateSign(){
        
        signImage.setImageResource(letterToSign.get(text.charAt(curIndex)));

    }
    public void onNextClicked(View view) {
        if(curIndex<text.length()) curIndex+=1;
        updateSign();

    }
    public void onPrevClicked(View view){
        if(curIndex>=0){
            curIndex-=1;
        }
        updateSign();
    }


    public void BacktoHomePage(View view) {
        Intent HomeIntent = new Intent(TextToSign.this, HomeActivity.class);
        startActivity(HomeIntent);

    }
}
package com.example.signvision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.signvision.Constants.backendAPI;
import static com.example.signvision.Constants.letterToSign;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadResourceValues();
        loadApiBackend();
        setContentView(R.layout.activity_home);
    }
    public void loadResourceValues(){
        for(char c: "abcdefghijklmnopqrstuvwxyz".toCharArray()){
            letterToSign.put(c,getResources().getIdentifier("@drawable/"+c,null,this.getPackageName()));
        }
        letterToSign.put(' ',getResources().getIdentifier("@drawable/a",null,this.getPackageName()));


    }
    public void loadApiBackend(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://167.99.119.124:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        backendAPI = retrofit.create(BackendAPI.class);

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
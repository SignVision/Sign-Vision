package com.example.signvision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class SignLanguagetoText extends AppCompatActivity {
    private ImageView mimageView;
    private static final int REQUEST_IMAGE_CAPTURE = 101;
    ArrayList<String> symbols = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_to_text);
    }

    public void BacktoHomePage(View view) {
        Intent HomeIntent = new Intent(SignLanguagetoText.this, HomeActivity.class);
        startActivity(HomeIntent);

    }

    public void takePicture(View view) {
        PIC_CODE = 0;
        takePicture();
    }

    public void takePicture() {
        symbols = new ArrayList<>();
        Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (imageTakeIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(imageTakeIntent, REQUEST_IMAGE_CAPTURE);
        }

    }

    public int PIC_CODE = 0;
    public void getTranslation(){


    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream .toByteArray();
            String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
            symbols.add(encoded);

            // get new image here like this
            if (PIC_CODE < 4) {
                takePicture();
                // add new requset of picture like this

                PIC_CODE++;
            }
            else{
                getTranslation();

            }
        }

    }
}
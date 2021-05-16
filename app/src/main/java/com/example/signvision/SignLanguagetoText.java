package com.example.signvision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.signvision.Constants.backendAPI;

public class SignLanguagetoText extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 101;
    ArrayList<String> symbols = new ArrayList<>();
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_to_text);
        textViewResult = findViewById(R.id.Sign_Translation);
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
        String translation = "";
        for(String pic:symbols){
            Post post = new Post(pic);
            Call<Post> call = backendAPI.createPost(post);
            call.enqueue(new Callback<Post>() {
                @Override
                public void onResponse(Call<Post> call, Response<Post> response) {
                    if(!response.isSuccessful()){
                        textViewResult.setText("Code: "+response.code());
                        return;

                    }

                    Post postResponse = response.body();

                    textViewResult.setText(postResponse.getText()+"\n");
                }

                @Override
                public void onFailure(Call<Post> call, Throwable t) {
                    Log.e("Fail", t.getLocalizedMessage());
                    Log.e("Fail", t.getMessage());
                    t.printStackTrace();
                    //textViewResult.setText(t.getMessage());

                }
            });

        }



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
            if (PIC_CODE < 0) {
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
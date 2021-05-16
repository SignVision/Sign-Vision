package com.example.signvision;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BackendAPI {
    @POST("img_to_char")
    Call<Post>createPost(@Body Post post);
}

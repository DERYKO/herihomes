package com.example.herihomes;

import org.json.JSONArray;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyApiEndpoint {
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> login(@Field("name") String name, @Field("password") String password);

    @GET("properties-sale")
    Call<ResponseBody> properties();
}

package com.example.herihomes;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class BaseUrl {
 private static final String baseUrl=" http://b6e611ee.ngrok.io/api/";

 public Retrofit initialize(){
  return new Retrofit.Builder()
          .baseUrl(baseUrl)
          .build();
 }

}

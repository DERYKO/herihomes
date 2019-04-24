package com.example.herihomes;

import retrofit2.Retrofit;

public class BaseUrl {
 private static final String baseUrl="https://ff2786bd.ngrok.io/api/";

 public MyApiEndpoint initialize(){
  MyApiEndpoint service = new Retrofit.Builder()
          .baseUrl(baseUrl)
          .build().create(MyApiEndpoint.class);
  return service;
 }

}

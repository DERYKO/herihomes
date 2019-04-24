package com.example.herihomes;

import retrofit2.Retrofit;

public class BaseUrl {
 private static final String baseUrl=" http://b6e611ee.ngrok.io/api/";

 public MyApiEndpoint initialize(){
  MyApiEndpoint service = new Retrofit.Builder()
          .baseUrl(baseUrl)
          .build().create(MyApiEndpoint.class);
  return service;
 }

}

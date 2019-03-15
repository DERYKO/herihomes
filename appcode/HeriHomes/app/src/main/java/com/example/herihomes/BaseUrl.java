package com.example.herihomes;

import retrofit2.Retrofit;

public class BaseUrl {
 private static final String baseUrl="http://f0fcdabf.ngrok.io/api/";

 public MyApiEndpoint initialize(){
  BaseUrl url=new BaseUrl();
  MyApiEndpoint service = new Retrofit.Builder()
          .baseUrl(baseUrl)
          .build().create(MyApiEndpoint.class);
  return service;
 }

}

package com.example.herihomes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Property extends AppCompatActivity implements SearchView.OnQueryTextListener {
RecyclerView recyclerView;
List<JSONObject> properties;
    PropertyRecylerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.widget.SearchView searchView= findViewById(R.id.search_bar);
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("search here");
        recyclerView= findViewById(R.id.Recylerview);
        properties=new ArrayList<>();
        BaseUrl url=new BaseUrl();
        Call<ResponseBody> call =url.initialize().properties();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    String stringResponse = null;
                    try {
                        stringResponse = response.body().string();
                        JSONObject object=new JSONObject(stringResponse);
                        JSONArray array=object.getJSONArray("properties");
                        for (int i=0;i<array.length();i++){
                            JSONObject object1=array.getJSONObject(i);
                            properties.add(object1);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(),""+t.toString(),Toast.LENGTH_SHORT).show();
            }
        });
      adapter=new PropertyRecylerViewAdapter(properties,getApplicationContext());
      recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
      recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        adapter.getFilter().filter(s);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}

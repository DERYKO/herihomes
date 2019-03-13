package com.example.herihomes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends Activity {
   EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.eT_username);
        password=findViewById(R.id.eT_password);

        final ImageView iV_houseLogin =findViewById(R.id.iV_houseLogin);
        iV_houseLogin.setImageResource(R.drawable.house);

        final Button bt_login =findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().isEmpty()){
                    username.setError("Username required!");
                    username.requestFocus();
                }else if(password.getText().toString().isEmpty()){
                    password.setError("Password is required!");
                    password.requestFocus();
                }else {
                    BaseUrl url=new BaseUrl();
                    Call<ResponseBody> call =url.initialize().login(username.getText().toString(),password.getText().toString());
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()) {
                                String stringResponse = null;
                                try {
                                    stringResponse = response.body().string();
                                    JSONObject object=new JSONObject(stringResponse);
                                    if (object.getString("message").equals("success")){
                                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                        LoginActivity.this.startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),""+object.getString("message"),Toast.LENGTH_SHORT).show();
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
                         Toast.makeText(getApplicationContext(),""+t.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });


    }
}

package com.example.herihomes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        final ImageView iV_houseLogin =(ImageView)findViewById(R.id.iV_houseLogin);
        iV_houseLogin.setImageResource(R.drawable.house);

        final Button bt_login = (Button)findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });


    }
}

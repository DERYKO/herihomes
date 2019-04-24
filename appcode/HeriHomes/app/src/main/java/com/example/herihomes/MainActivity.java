package com.example.herihomes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
ImageView property;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        property=findViewById(R.id.imageView6);
        property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Property.class);
                startActivity(intent);
            }
        });
        final ImageView iV_dashboard =(ImageView)findViewById(R.id.iV_dashboard);
        iV_dashboard.setImageResource(R.drawable.dashboard);

        final ImageView iV_peter =(ImageView)findViewById(R.id.iV_peter);
        iV_peter.setImageResource(R.drawable.peter);
    }
}

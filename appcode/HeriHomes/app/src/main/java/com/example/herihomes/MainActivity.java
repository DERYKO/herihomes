package com.example.herihomes;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        final ImageView iV_dashboard =(ImageView)findViewById(R.id.iV_dashboard);
        iV_dashboard.setImageResource(R.drawable.dashboard);

        final ImageView iV_peter =(ImageView)findViewById(R.id.iV_peter);
        iV_peter.setImageResource(R.drawable.peter);
    }
}

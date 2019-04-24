package com.example.herihomes;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class payrentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_payrent);

        final ImageView iv_hao = (ImageView) findViewById(R.id.iv_hao);
        iv_hao.setImageResource(R.drawable.building);

        final ImageView iv_mpesa = (ImageView) findViewById(R.id.iv_mpesa);
        iv_mpesa.setImageResource(R.drawable.mpesa);

        final ImageView iv_paypal = (ImageView) findViewById(R.id.iv_paypal);
        iv_paypal.setImageResource(R.drawable.paypal);

        final ImageView iv_chart = (ImageView) findViewById(R.id.iv_chart);
        iv_chart.setImageResource(R.drawable.chart);

        final ImageView iv_inbox = (ImageView) findViewById(R.id.iv_inbox);
        iv_inbox.setImageResource(R.drawable.inbox);

        final ImageView iv_setting = (ImageView) findViewById(R.id.iv_setting);
        iv_setting.setImageResource(R.drawable.settings);

        final ImageView iv_logout = (ImageView) findViewById(R.id.iv_logout);
        iv_logout.setImageResource(R.drawable.logout);

        iv_mpesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BaseUrl().initialize().rent().enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(getApplicationContext(), "" +response.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}

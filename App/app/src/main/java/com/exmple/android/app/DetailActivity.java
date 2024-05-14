package com.exmple.android.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName, tvPhone, tvRent, tvWaterSkyFee, tvTogether;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        bindWidget();
        setEvents();
        setUiData();

    }

    private void bindWidget() {
        tvName = (TextView) findViewById(R.id.tvName);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvRent = (TextView) findViewById(R.id.tvRent);
        tvWaterSkyFee = (TextView) findViewById(R.id.tvWaterSkyFee);
        tvTogether = (TextView) findViewById(R.id.tvTogether);
        btnBack = (Button) findViewById(R.id.btnBack);
    }

    private void setEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setUiData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String rent = intent.getStringExtra("rent");
        String waterAndSkyFees = intent.getStringExtra("water_and_sky_fee");
        String together = intent.getStringExtra("together");

        tvName.setText(name);
        tvPhone.setText(phone);
        tvRent.setText(rent);
        tvWaterSkyFee.setText(waterAndSkyFees);
        tvTogether.setText(together);
    }
}
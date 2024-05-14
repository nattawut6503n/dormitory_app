package com.exmple.android.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private ApiService service;
    private List<UserDao> userDataList;
    private EditText edtUsername, edtPassword;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRetrofit();
        callApiGetUserData();
        bindWidget();
        setEvents();
    }

    private void bindWidget() {
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
    }

    private void setEvents() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                UserDao userData = findUserData(username, password);
                if (userData != null) {
                    openDetailActivity(userData);
                } else {
                    Toast.makeText(MainActivity.this, "search failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void openDetailActivity(UserDao userData) {
        String name = userData.getName();
        String phone = userData.getPhone();
        String rent = userData.getRent();
        String waterAndSkyFees = userData.getWaterAndSkyFee();
        String together = userData.getTogether();

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("phone", phone);
        intent.putExtra("rent", rent);
        intent.putExtra("water_and_sky_fee", waterAndSkyFees);
        intent.putExtra("together", together);
        startActivity(intent);
    }

    private UserDao findUserData(String username, String password) {
        if (userDataList != null) {
            for (UserDao userData : userDataList) {
                if (userData.getUsername().equals(username) && userData.getPassword().equals(password)) {
                    return userData;
                }
            }
        }
        return null;
    }

    private void setupRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        Gson gson = gsonBuilder.create();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://script.google.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(ApiService.class);
    }

    private void callApiGetUserData() {
        Call<List<UserDao>> call = service.getUserData();
        call.enqueue(new Callback<List<UserDao>>() {
            @Override
            public void onResponse(Call<List<UserDao>> call, Response<List<UserDao>> response) {
                if (response.isSuccessful()) {
                    List<UserDao> dao = response.body();
                    userDataList = dao;
                } else {
                    Toast.makeText(MainActivity.this, "ไม่สามารถเชื่อมต่อ Server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<UserDao>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "เกิดข้อผิดพลาดบางอย่าง", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
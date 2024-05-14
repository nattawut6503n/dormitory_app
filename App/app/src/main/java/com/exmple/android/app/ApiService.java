package com.exmple.android.app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("macros/s/AKfycbyfFZo00O97bXy2Y2gxhsDPmiZIpD3eS-pNymWrsTxFGk6Gvx_qMDsKmafiA42PCDQ6/exec")
    Call<List<UserDao>> getUserData();

}
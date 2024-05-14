package com.exmple.android.app;

import com.google.gson.annotations.SerializedName;

public class UserDao {
    @SerializedName("Username")
    private String username;
    @SerializedName("Password")
    private String password;
    @SerializedName("Name")
    private String name;
    @SerializedName("Phone")
    private String phone;
    @SerializedName("Rent")
    private String rent;
    @SerializedName("Water_and_sky_fees")
    private String waterAndSkyFee;
    @SerializedName("Together")
    private String together;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getWaterAndSkyFee() {
        return waterAndSkyFee;
    }

    public void setWaterAndSkyFee(String waterAndSkyFee) {
        this.waterAndSkyFee = waterAndSkyFee;
    }

    public String getTogether() {
        return together;
    }

    public void setTogether(String together) {
        this.together = together;
    }
}

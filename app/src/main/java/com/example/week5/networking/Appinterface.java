package com.example.week5.networking;

import com.example.week5.models.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Appinterface {

    @GET("api/?results=15")
    Call<UserResponse> getUsers();

}
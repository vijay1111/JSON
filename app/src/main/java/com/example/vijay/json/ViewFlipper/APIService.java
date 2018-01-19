package com.example.vijay.json.ViewFlipper;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vijay on 11/28/17.
 */
public interface APIService {

    @GET("heroes.php")
    Call<Heroes> getHeroes();
}

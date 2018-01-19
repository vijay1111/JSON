package com.example.vijay.json.ViewFlipper;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by vijay on 11/28/17.
 */

public class Heroes {
    @SerializedName("heroes")
    private ArrayList<Hero> heros;

    public Heroes(){

    }

    public ArrayList<Hero> getHeros(){
        return heros;
    }

}

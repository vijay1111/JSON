package com.example.vijay.json.ViewFlipper;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vijay on 11/28/17.
 */

public class Hero {
    @SerializedName("name")
    private String name;

    @SerializedName("imageurl")
    private String url;

    public Hero(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}

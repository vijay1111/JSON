package com.example.vijay.json.RetrofitCheezyCode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vijay.json.R;

public class RetrofitActivity extends AppCompatActivity {
public static final String url="https://api.github.com/users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
    }
}

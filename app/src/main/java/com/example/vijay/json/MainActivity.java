package com.example.vijay.json;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.vijay.json.DisplayRecyclerView.DisplayDataActivity;
import com.example.vijay.json.ExpandableRecyclerView.ExpandableRecyclerViewActivity;
import com.example.vijay.json.GSON_With_Volley.GsonWithVolley;
import com.example.vijay.json.Jsoup.JsoupActivity;
import com.example.vijay.json.RecyclerView.RecyclerViewActivity;
import com.example.vijay.json.RetrofitCheezyCode.RetrofitActivity;
import com.example.vijay.json.UploadImage.UploadImageActivity;
import com.example.vijay.json.ViewFlipper.ViewFlipperActivity;
import com.example.vijay.json.VolleyAndroidHive.Volley_Receive_Data;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void view_click(View view) {
        Class clazz = null;
        switch (view.getId()) {
            case R.id.display:
                clazz = DisplayDataActivity.class;
                break;
            case R.id.upload_image:
                clazz = UploadImageActivity.class;
                break;
            case R.id.view_Flipper:
                clazz = ViewFlipperActivity.class;
                break;
            case R.id.expandable_recycler_view:
                clazz = ExpandableRecyclerViewActivity.class;
                break;

            case R.id.volley_display_data:
                clazz = Volley_Receive_Data.class;
                break;
            case R.id.gson:
                clazz= GsonWithVolley.class;
                break;
            case R.id.retrofit:
                clazz= RetrofitActivity.class;
                break;

            case R.id.recyclerview:
                clazz= RecyclerViewActivity.class;
                break;
            case R.id.Jsoup:
                clazz= JsoupActivity.class;
                break;
        }
        startActivity(new Intent(getApplicationContext(), clazz));
    }
}

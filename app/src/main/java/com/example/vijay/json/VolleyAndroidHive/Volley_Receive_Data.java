package com.example.vijay.json.VolleyAndroidHive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.example.vijay.json.AppController;
import com.example.vijay.json.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static com.example.vijay.json.R.id.msgResponse;

public class Volley_Receive_Data extends AppCompatActivity {
    private String TAG = Volley_Receive_Data.class.getSimpleName();
    private TextView textView;
    private NetworkImageView imgNetWorkView;
    // These tags will be used to cancel the requests
    private String tag_json_obj = "tag_json_obj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley__receive__data);
        textView = (TextView) findViewById(msgResponse);
        imgNetWorkView = (NetworkImageView) findViewById(R.id.imgNetwork);

    }

    public void view_click(View view) {
        switch (view.getId()) {
            case R.id.json_object_request:
                makeJsonObjReq();
                break;
            case R.id.jsonArray:
                jsonArrayRequest();
                break;
            case R.id.string_request:
                stringRequestMethod();
                break;
            case R.id.image_receive:
                imageReceiveMethod();
                break;
        }
    }

    private void imageReceiveMethod() {
        ImageLoader imageLoader = AppController.getInstance().getImageLoader();
        imgNetWorkView.setImageUrl(Const.JSON_IMAGE_URL, imageLoader);
        // Loading image with placeholder and error image
//        imageLoader.get(Const.JSON_IMAGE_URL, ImageLoader.getImageListener(
//                imageView, R.drawable.ico_loading, R.drawable.ico_error));
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(Const.JSON_IMAGE_URL);
        if (entry != null) {
            try {
                String data = new String(entry.data, "UTF-8");
                // handle data, like converting it to xml, json, bitmap etc.,
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            // cached response doesn't exists. Make a network call here
        }
    }

    private void makeJsonObjReq() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Const.JSON_OBJECT_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e(TAG, response.toString());
                        textView.setText(response.toString());

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                Log.e(TAG, headers.toString());
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "Androidhive");
                params.put("email", "abc@androidhive.info");
                params.put("pass", "password123");
                Log.e(TAG, params.toString());
                return params;
            }
        };

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
//        AppController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }

    private void stringRequestMethod() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Const.JSON_String_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText(response.toString());
            }
        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.toString());
            }
        }
        );
        AppController.getInstance().addToRequestQueue(stringRequest);

    }

    private void jsonArrayRequest() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Const.JSON_ARRAY_URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e(TAG, response.toString());
                        textView.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage());
            }
        }


        );
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }
}

package com.example.vijay.json.DisplayRecyclerView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.vijay.json.AppController;
import com.example.vijay.json.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class DisplayDataActivity extends AppCompatActivity {
    private static final String URL_PRODUCTS = "http://192.168.0.107/json/Api.php";
    ArrayList<Product> arrayList;
    RecyclerView recyclerView;
    private String TAG = DisplayDataActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        recyclerView = (RecyclerView) findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<>();
        loadProducts();
    }

    private void loadProducts() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e(TAG,response.toString());
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        Product[] product = gson.fromJson(response, Product[].class);
                        recyclerView.setAdapter(new ProductsAdapter(DisplayDataActivity.this, product));
//                        try {
//                            JSONArray jsonArray = new JSONArray(response);
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                                arrayList.add(new Product(
//                                        jsonObject.getInt("id"),
//                                        jsonObject.getString("title"),
//                                        jsonObject.getString("shortdesc"),
//                                        jsonObject.getDouble("rating"),
//                                        jsonObject.getDouble("price"),
//                                        jsonObject.getString("image")
//                                ));
//                            }
//                            ProductsAdapter adapter = new ProductsAdapter(getApplicationContext(), arrayList);
//                            recyclerView.setAdapter(adapter);
//                        }
//                        catch(JSONException e){
//                            System.out.println(e.toString());
//                            e.printStackTrace();
//                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("error" + error.toString());

                    }
                });
        AppController.getInstance().addToRequestQueue(stringRequest);
    }
}
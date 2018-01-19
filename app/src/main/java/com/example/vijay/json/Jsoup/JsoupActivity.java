package com.example.vijay.json.Jsoup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.vijay.json.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupActivity extends AppCompatActivity {
    public String html = "";
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsoup);
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        textView = (TextView) findViewById(R.id.mTextView);


        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                "http://ab2015.anadolu.edu.tr/index.php?menu=8",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        html = response;
                        //textView.setText(html);

                        Document document = Jsoup.parse(html);
                        Element element = document.select("div.col-lg-12").first();

                        Elements elements = element.getElementsByTag("a");

                        String a = "";
                        for (Element el : elements) {
                            a += el.html() + "\n";
                        }

                        textView.setText(a);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("Hata: " + error.getMessage());
            }
        });

        requestQueue.add(stringRequest);
    }
}

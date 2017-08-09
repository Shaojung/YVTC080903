package com.example.yvtc.yvtc080903;

import android.graphics.Bitmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(MainActivity.this);

    }
    public void click1(View v)
    {
        ImageRequest request = new ImageRequest("http://images.meredith.com/content/dam/bhg/Images/2006/03/SIP943899.jpg.rendition.largest.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        ImageView img = (ImageView) findViewById(R.id.imageView);
                        img.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.FIT_CENTER, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("VOLLEY", error.getMessage());
            }
        });
        queue.add(request);
        queue.start();
    }
}

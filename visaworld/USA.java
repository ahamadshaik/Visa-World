package com.evil.example.visaworld;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ahamad shaik on 12-02-2017.
 */
public class USA extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_usa);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(USA.this, SecondActivity.class);
                startActivity(i);
                finish();
            }
        },2000);
    }
}

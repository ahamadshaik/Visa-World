package com.evil.example.visaworld;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.evil.example.visaworld.HTextView;
import com.evil.example.visaworld.HTextViewType;
import com.evil.example.visaworld.MainActivity;
import com.evil.example.visaworld.R;

/**
 * Created by ahamad shaik on 05-02-2017.
 */

public class SplashActivity extends AppCompatActivity{

    public static int time_splash = 2000;
    String[] sentences = new String[]{"VISA WORLD"};
    private int mCounter = 0;
    private HTextView hTextView;
    Handler mhandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        hTextView = (HTextView) findViewById(R.id.text2);
        hTextView.setTextColor(Color.BLACK);
        hTextView.setBackgroundColor(Color.WHITE);
        hTextView.setTypeface(null);
        hTextView.setAnimateType(HTextViewType.LINE);
        mhandler.postDelayed(new Runnable() {
            public void run() {
                hTextView.animateText(sentences[mCounter]);
                new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                    @Override
                    public void run() {
                        // This method will be executed once the timer is over
                        // Start your app main activity
                        Intent i = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(i);

                        // close this activity
                        finish();
                    }
                }, time_splash);
            }
        }, 1000);

    }
}

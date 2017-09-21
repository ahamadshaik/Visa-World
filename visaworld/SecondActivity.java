package com.evil.example.visaworld;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by ahamad shaik on 04-03-2017.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final DataBaseHelper dbhelper = new DataBaseHelper(this);
        final String seq = dbhelper.reqorNot();
        final String s3 = dbhelper.touristVisaRecord();
        final String s5 = dbhelper.businessVisaRecord();
        final String s7 = dbhelper.workVisaRecord();
        final String s9 = dbhelper.studyVisaRecord();
        LinearLayout r1 = new LinearLayout(this);
        r1.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(50,100,10,10);
        TextView req = new TextView(this);
        req.setText(seq);

        req.setTextSize(40);
        req.setPadding(0,45,100,0);
        req.setGravity(Gravity.CENTER);
        r1.addView(req);
        r1.setBackgroundResource(R.drawable.second2);

        TextView t3 = new TextView(this);
        t3.setText("tourist visa");
        t3.setTextSize(30);
        t3.setLayoutParams(params);
        t3.setTextColor(Color.BLACK);

        TextView t5 = new TextView(this);
        t5.setText("business visa");
        t5.setTextSize(30);
        t5.setLayoutParams(params);
        t5.setTextColor(Color.BLACK);


        TextView t7 = new TextView(this);
        t7.setText("work visa");
        t7.setTextSize(30);
        t7.setLayoutParams(params);
        t7.setTextColor(Color.BLACK);


        TextView t9 = new TextView(this);
        t9.setText("study visa");
        t9.setTextSize(30);
        t9.setLayoutParams(params);
        t9.setTextColor(Color.BLACK);
        if(s3 == "visa not required")
        {
            req.setTextColor(Color.GREEN);
        }
        else {
            req.setTextColor(Color.RED);

        }

        if(s3!=null)
        {
            r1.addView(t3);
        }

        if(s5!=null)
        {
            r1.addView(t5);
        }

        if(s7!=null)
        {
            r1.addView(t7);
        }

        if (s9 != null)
        {
            r1.addView(t9);
        }
        setContentView(r1);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(s3));
                startActivity(browserIntent);
            }
        });

        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(s5));
                startActivity(browserIntent);
            }
        });

        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(s7));
                startActivity(browserIntent);
            }
        });

        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(s9));
                startActivity(browserIntent);
            }
        });





    }
}


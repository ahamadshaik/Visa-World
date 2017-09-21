package com.evil.example.visaworld;

import android.graphics.Canvas;
import android.util.AttributeSet;

/**
 * Created by ahamad shaik on 11-02-2017.
 */

public interface IHText {
    void init(HTextView hTextView, AttributeSet attrs, int defStyle);
    void animateText(CharSequence text);
    void onDraw(Canvas canvas);
    void reset(CharSequence text);
}

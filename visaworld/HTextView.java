package com.evil.example.visaworld;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by ahamad shaik on 11-02-2017.
 */

public class HTextView extends TextView {

    private IHText mIHText = new LineText();
    private AttributeSet attrs;
    private int defStyle;
    private int animateType;

    public HTextView(Context context) {
        super(context);
        init(null, 0);
    }

    public HTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public HTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {

        this.attrs = attrs;
        this.defStyle = defStyle;

        // Get the attributes array
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.HTextView);
        final String fontAsset = typedArray.getString(R.styleable.HTextView_fontAsset);

        if (!this.isInEditMode()) {
            // Set custom typeface
            if (fontAsset != null && !fontAsset.trim().isEmpty()) {
                setTypeface(Typeface.createFromAsset(getContext().getAssets(), fontAsset));
            }
        }



        mIHText = new LineText();


        typedArray.recycle();
        initHText(attrs, defStyle);
    }

    private void initHText(AttributeSet attrs, int defStyle) {
        mIHText.init(this, attrs, defStyle);
    }

    public void animateText(CharSequence text) {
        mIHText.animateText(text);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mIHText.onDraw(canvas);
    }

    public void reset(CharSequence text) {
        mIHText.reset(text);
    }

    public void setAnimateType(HTextViewType type) {
        mIHText = new LineText();

        initHText(attrs, defStyle);
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState state = new SavedState(superState);
        state.animateType = animateType;
        return state;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(state);
        animateType = ss.animateType;
    }

    public static class SavedState extends BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int animateType;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        public SavedState(Parcel source) {
            super(source);
            animateType = source.readInt();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(animateType);
        }

        @Override
        public int describeContents() {
            return 0;
        }
    }

}

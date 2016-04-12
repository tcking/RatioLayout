package com.github.tcking.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by tcking on 15/12/22.
 */
public class RatioLayoutHelper {
    private float ratio;

    public void setRatio(float ratio, boolean baseOnWidth) {
        this.ratio = ratio;
        this.baseOnWidth = baseOnWidth;
    }

    private boolean baseOnWidth = true;
    private int widthMeasureSpec;
    private int heightMeasureSpec;

    public static RatioLayoutHelper obtain(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        RatioLayoutHelper ratioLayoutHelper = new RatioLayoutHelper();
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.RatioLayout, defStyleAttr, defStyleRes);
            if (typedArray != null) {
                String ratio = typedArray.getString(R.styleable.RatioLayout_ratio);
                if (!TextUtils.isEmpty(ratio)) {
                    if (ratio.contains(":")) {
                        String[] tmp = ratio.split(":");
                        ratioLayoutHelper.ratio = Float.parseFloat(tmp[0]) / Float.parseFloat(tmp[1]);
                    } else {
                        ratioLayoutHelper.ratio = Float.parseFloat(ratio);
                    }
                    ratioLayoutHelper.baseOnWidth = 0 == typedArray.getInt(R.styleable.RatioLayout_ratioBase, 0);
                }
            }
        } catch (Exception e) {
            Log.e("RatioLayoutHelper", "view init error", e);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        return ratioLayoutHelper;
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.widthMeasureSpec = widthMeasureSpec;
        this.heightMeasureSpec = heightMeasureSpec;
        if (ratio > 0) {
            if (baseOnWidth) {
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                this.heightMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (size / ratio), View.MeasureSpec.EXACTLY);
            } else {
                int size = View.MeasureSpec.getSize(heightMeasureSpec);
                this.widthMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (size * ratio), View.MeasureSpec.EXACTLY);
            }
        }
    }

    public int getWidthMeasureSpec() {
        return widthMeasureSpec;
    }

    public int getHeightMeasureSpec() {
        return heightMeasureSpec;
    }
}

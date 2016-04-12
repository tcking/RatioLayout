package com.github.tcking.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 *
 * Created by tcking on 16/1/5.
 */
public class RatioLinearLayout extends LinearLayout implements Ratioable{
    private RatioLayoutHelper ratioLayoutHelper;

    public RatioLinearLayout(Context context) {
        super(context);
    }

    public RatioLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        ratioLayoutHelper=RatioLayoutHelper.obtain(context,attrs,0,0);
    }

    public RatioLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ratioLayoutHelper=RatioLayoutHelper.obtain(context,attrs,defStyleAttr,0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RatioLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        ratioLayoutHelper=RatioLayoutHelper.obtain(context,attrs,defStyleAttr,defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (ratioLayoutHelper != null) {
            ratioLayoutHelper.onMeasure(widthMeasureSpec, heightMeasureSpec);
            widthMeasureSpec=ratioLayoutHelper.getWidthMeasureSpec();
            heightMeasureSpec=ratioLayoutHelper.getHeightMeasureSpec();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void setRatio(float ratio,boolean baseOnWidth) {
        if (ratioLayoutHelper != null) {
            ratioLayoutHelper.setRatio(ratio, baseOnWidth);
            requestLayout();
        }
    }
}

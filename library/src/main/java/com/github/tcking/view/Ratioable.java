package com.github.tcking.view;

/**
 * Created by tcking on 16/1/5.
 */
public interface Ratioable {
    /**
     * 设置缩放比例:宽/高的浮点数
     * @param ratio
     * @param baseOnWidth true表示以宽为基础计算高的值,false表示以高为基础计算宽的值
     */
    void setRatio(float ratio,boolean baseOnWidth);
}

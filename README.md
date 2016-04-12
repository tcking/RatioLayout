# RatioLayout
LinearLayout or RelativeLayout's width/height with specified ratio,for example:

``` xml
<com.github.tcking.view.RatioRelativeLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:ratio="4:3"
        >
        ...
 </com.github.tcking.view.RatioRelativeLayout>
```
the ratio default base on width,we also can specified ratio base on height via:`app:ratioBase="height"`

need more RatioLayout? if u using android studio that is simple,just open `RatioLinearLayout` type `F5` change target class name,and then change target class super class what you want
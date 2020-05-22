@BindingAdapter("android:layout_width")
public static void setLayoutWidth(View view, float width) {
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    layoutParams.width = (int)width;
    view.setLayoutParams(layoutParams);
}
@BindingAdapter("layout_height")
public static void setLayoutHeight(View view, float height) {
    LayoutParams layoutParams = view.getLayoutParams();
    layoutParams.height = height;
    view.setLayoutParams(layoutParams);
}
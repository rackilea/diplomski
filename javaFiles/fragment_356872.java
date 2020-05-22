private LinearLayout addLinearLayout(LinearLayout linearLayout, int orientation) {
    //Create new horizontal linear layout and add to the specified linear layout
    LinearLayout newLinearLayout = new LinearLayout(context);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    layoutParams.setMargins(20, 10, 0, 10);
    newLinearLayout.setOrientation(orientation);
    linearLayout.addView(newLinearLayout, layoutParams);
    return newLinearLayout;
}
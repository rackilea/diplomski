if (dataOk) {
    skipButton.setVisibility(View.GONE);
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mapСontainer.getLayoutParams();
    layoutParams.height = 0;
    layoutParams.weight = 1;
    mapСontainer.setLayoutParams(layoutParams);
    mapСontainer.getParent().requestLayout();
} else {
    int visibility = skipButton.getVisibility();
    skipButton.setVisibility(View.VISIBLE);

    if (visibility == View.GONE) {
        int height = mapСontainer.getMeasuredHeight();
        ViewGroup.LayoutParams skipParams = skipButton.getLayoutParams();
        LinearLayout.LayoutParams containerParams = (LinearLayout.LayoutParams) mapСontainer.getLayoutParams();
        containerParams.height = height - skipParams.height;
        containerParams.weight = 0;
        mapСontainer.setLayoutParams(containerParams);
    }
}
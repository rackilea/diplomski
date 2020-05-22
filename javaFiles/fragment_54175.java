private void removeCustomImageViews(final ViewGroup vg) {
    final int childCount = vg.getChildCount();

    for(int i = 0; i < childCount; i++) {
        final View child = vg.getChildAt(i);

        if(child instanceof CustomImageView) {
            vg.removeView(child);
        }
        else if(child instanceof ViewGroup) {
            removeCustomImageViews((ViewGroup) child);
        }
    }
}
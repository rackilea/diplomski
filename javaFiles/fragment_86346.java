private void setAppFontColor(ViewGroup mContainer, int color) {
    if (mContainer == null || color == 0)
        return;

    final int mCount = mContainer.getChildCount();

    for (int i = 0; i < mCount; ++i) {
        final View mChild = mContainer.getChildAt(i);
        if (mChild instanceof TextView) {
            ((TextView) mChild).setTextColor(color);
        } else if (mChild instanceof Button) {
            ((Button) mChild).setTextColor(color);
        } else if (mChild instanceof ViewGroup) {
            setAppFontColor((ViewGroup) mChild, color);
        }
    }
}
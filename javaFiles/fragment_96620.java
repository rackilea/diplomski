@Override
protected void onLayout(boolean changed, int l, int t, int r, int b) {
    mDragRange = getHeight() - mHeaderView.getHeight();

    if (firstRun) {
        firstRun = false;
        mDescView.getLayoutParams().height = getHeight() - mHeaderView.getMeasuredHeight();
    }

    mHeaderView.layout(
            0,
            mTop,
            r,
            mTop + mHeaderView.getMeasuredHeight());

    mDescView.layout(
            0,
            mTop + mHeaderView.getMeasuredHeight(),
            r,
            mTop  + b);
}
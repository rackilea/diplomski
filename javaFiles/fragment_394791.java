@Override
protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (mItemAnimator != null) {
        mItemAnimator.endAnimations();
    }
    mFirstLayoutComplete = false;
    stopScroll();
    mIsAttached = false;
    if (mLayout != null) {
        mLayout.onDetachedFromWindow(this, mRecycler);
    }
    removeCallbacks(mItemAnimatorRunner);
}
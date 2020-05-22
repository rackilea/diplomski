private void drawBackground(Canvas canvas) {
    final Drawable background = mBackground;
    if (background == null) {
        return;
    }

    if (mBackgroundSizeChanged) {
        background.setBounds(0, 0,  mRight - mLeft, mBottom - mTop);
        mBackgroundSizeChanged = false;
       rebuildOutline();
    }

    //draw background through background.draw(canvas)
}
@Override
protected void onDraw(Canvas canvas) {

    getBackground().draw(canvas);
    mPath.reset();
    getDrawingRect(tmpRect);

    if (mRoundRect.left != tmpRect.left || mRoundRect.right != tmpRect.right ||
            mRoundRect.top != tmpRect.top || mRoundRect.bottom != tmpRect.bottom) {
        mRoundRect.set(tmpRect.left+border, tmpRect.top+border, tmpRect.right-border, tmpRect.bottom-border);
        mPath.addRoundRect(mRoundRect, floatsRadiuses, Path.Direction.CW);
        canvas.clipPath(mPath);
    }

    int childrenSize = getChildCount();
    for(int i=0;i<childrenSize;i++){
        View child = getChildAt(i);
        drawChild(canvas,child,getDrawingTime());
    }


}
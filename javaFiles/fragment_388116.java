protected void onDraw(Canvas canvas) {
    if (mBitmap != null && !mBitmap.isRecycled()) {
        if(isNewImage) {
            canvas.drawBitmap(mBitmap, mImgTrans.srcRect, mImgTrans.viewRect, mPaintNegative);
            invalidate();
        } else {
            canvas.drawBitmap(mBitmap, mImgTrans.srcRect, mImgTrans.viewRect, mPaint);
        }
     }
}
Bitmap mDrawBitmap;
Canvas mBitmapCanvas;
Paint mDrawPaint = new Paint();

@Override
public void onDraw(Canvas canvas) {

    if (mDrawBitmap == null) {
        mDrawBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        mBitmapCanvas = new Canvas(mDrawBitmap);
    }

    // draw on the btimapCanvas
    //... and more
    mBitmapCanvas.drawWhatever(...);

    // after drawing with the bitmapcanvas,
    //all drawn information is stored in the Bitmap       

    // draw everything to the screen
    canvas.drawBitmap(mDrawBitmap, 0, 0, mDrawPaint);
}
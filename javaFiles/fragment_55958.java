Bitmap mDrawBitmap;
Canvas mBitmapCanvas;
Paint drawPaint = new Paint();

@Override
public void onDraw(Canvas canvas) {

    drawPaint.setColor(Color.RED);

    if (mDrawBitmap == null) {
        mDrawBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        mBitmapCanvas = new Canvas(mDrawBitmap);
    }

    // clear previously drawn stuff
    mBitmapCanvas.drawColor(Color.WHITE);

    // draw on the btimapCanvas
    mBitmapCanvas.drawStuff(...);
    //... and more

    // after drawing with the bitmapcanvas,
    //all drawn information is stored in the Bitmap    


    // draw everything to the screen
    canvas.drawBitmap(mDrawBitmap, 0, 0, drawPaint);
}
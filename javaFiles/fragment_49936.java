@Override
protected void onDraw(Canvas canvas) {
    // draw a circle that is erasing bitmap
    super.onDraw(canvas);
    canvas.drawBitmap(bm2, 0, 0, null);
    pcanvas.drawBitmap(bm1, 0, 0, null);
    pcanvas.drawCircle(x, y, 40, mPaint);
    canvas.drawBitmap(bmOverlay, 0, 0, null);

    // erase the top bitmap:
    Canvas bitmapCanvas = new Canvas(bm1);
    bitmapCanvas.drawBitmap(bm2, 0, 0, null);
    bitmapCanvas.drawBitmap(bmOverlay, 0, 0, null);
}
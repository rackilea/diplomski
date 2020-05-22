@Override
protected void onDraw(Canvas canvas) {
    canvas.drawBitmap(planeFrames[i], plane.getCenterX(), 0, null);
    if(++i >= planeFrames.length) {
       i = 0;
    }
    invalidate(bmpRect);
}
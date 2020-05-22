public Bitmap getCircleBitmap(int dimenSize,int mColor) {
    Bitmap output = Bitmap.createBitmap(dimenSize, dimenSize, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(output);
    int x = dimenSize;
    int y = dimenSize;
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setStyle(Paint.Style.FILL);
    paint.setColor(Color.TRANSPARENT);
    canvas.drawPaint(paint);
    canvas.drawBitmap(output, 0.0f, 0.0f, paint);
    paint.setColor(mColor);
    canvas.drawCircle(x / 2, y / 2, dimenSize/2, paint);
    return output;
}
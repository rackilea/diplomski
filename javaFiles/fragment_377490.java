public Bitmap myDrawText(Context context, String text, Typeface typeface, int  textSize, int width, int height) {
    Bitmap myBitmap = Bitmap.createBitmap(width, height,      Bitmap.Config.ARGB_8888);
    Canvas myCanvas = new Canvas(myBitmap);
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setSubpixelText(true);
    paint.setTypeface(typeface);
    paint.setStyle(Paint.Style.FILL);
    paint.setColor(Color.WHITE);
    paint.setTextSize(textSize);
    paint.setTextAlign(Align.CENTER);
    myCanvas.drawText(text, (width / 2), 40, paint);
    return myBitmap;
}
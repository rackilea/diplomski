public Bitmap makeTintedBitmap(Bitmap src, int color) {
    Bitmap result = Bitmap.createBitmap(src.getWidth(), src.getHeight(), src.getConfig());
    Canvas c = new Canvas(result);
    Paint paint = new Paint();
    paint.setColorFilter(new LightingColorFilter(color,0));
    c.drawBitmap(src, 0, 0, paint);
    return result;
}
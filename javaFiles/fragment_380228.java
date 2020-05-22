public static Bitmap getCircularBitmapFrom(Bitmap bitmap) {
    if (bitmap == null || bitmap.isRecycled()) {
        return null;
    }
    float radius = bitmap.getWidth() > bitmap.getHeight() ? ((float) bitmap
            .getHeight()) / 2f : ((float) bitmap.getWidth()) / 2f;
    Bitmap canvasBitmap = Bitmap.createBitmap(bitmap.getWidth(),
            bitmap.getHeight(), Bitmap.Config.ARGB_8888);
    BitmapShader shader = new BitmapShader(bitmap, TileMode.CLAMP,
            TileMode.CLAMP);
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setShader(shader);

    Canvas canvas = new Canvas(canvasBitmap);

    canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
            radius, paint);

    return canvasBitmap;
}
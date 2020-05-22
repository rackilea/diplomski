private Bitmap getCircularBitmap(int radius, Bitmap bitmap) {
    Bitmap.Config conf = Bitmap.Config.ARGB_8888;
    Bitmap bmp = Bitmap.createBitmap(radius, radius, conf);
    Canvas canvas = new Canvas(bmp);

    // creates a centered bitmap of the desired size
    bitmap = ThumbnailUtils.extractThumbnail(bitmap, radius, radius, ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
    BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    Paint paint = new Paint();
    paint.setAntiAlias(true);

    paint.setShader(shader);
    RectF rect = new RectF(0, 0, radius, radius);
    canvas.drawRoundRect(rect, radius, radius, paint);

    return bmp;
}
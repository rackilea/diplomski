public Bitmap getBitmap(Bitmap original)
{
    Bitmap bitmap = Bitmap.createBitmap(original.getWidth(), 
    original.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);

    Paint paint = new Paint();
    paint.setColorFilter(new ColorMatrixColorFilter(getColorMatrix()));
    canvas.drawBitmap(original, 0, 0, paint);

    return bitmap;
}

private ColorMatrix getColorMatrix() {
    return new ColorMatrix(new float[] {
        -1,  0,  0,  0, 255,
        0, -1,  0,  0, 255,
        0,  0, -1,  0, 255,
        0,  0,  0,  1,   0
    });
}
private Bitmap getBitmapFromString(String text, float fontSizeSP, Context context) {
    int fontSizePX = convertDiptoPix(context, fontSizeSP);
    int pad = (fontSizePX / 9);
    Paint paint = new Paint();

    paint.setAntiAlias(true);
    paint.setColor(Color.WHITE);
    paint.setTextSize(fontSizePX);

    int textWidth = (int) (paint.measureText(text) + pad * 2);
    int height = (int) (fontSizePX / 0.75);
    Bitmap bitmap = Bitmap.createBitmap(textWidth, height, Bitmap.Config.ARGB_4444);
    Canvas canvas = new Canvas(bitmap);
    float xOriginal = pad;
    canvas.drawText(text, xOriginal, fontSizePX, paint);

    return bitmap;
}
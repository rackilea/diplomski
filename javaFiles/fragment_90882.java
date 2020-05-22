// code from that answer put into method from above
public static Bitmap createGrayscale(Bitmap src) {
    int width = src.getWidth();
    int height = src.getHeight();
    Bitmap bmOut = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bmOut);
    ColorMatrix ma = new ColorMatrix();
    ma.setSaturation(0);
    Paint paint = new Paint();
    paint.setColorFilter(new ColorMatrixColorFilter(ma));
    canvas.drawBitmap(src, 0, 0, paint);
    return bmOut;
}
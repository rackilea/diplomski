public static Bitmap overlay(Bitmap bmp1, Bitmap bmp2) {
    Bitmap resizedBitmap = Bitmap.createScaledBitmap(bmp2, 500, 500, false);
    Bitmap bitmapWithOverlay = Bitmap.createBitmap(bmp1.getWidth(), bmp1.getHeight(), bmp1.getConfig());
    Canvas canvas = new Canvas(bitmapWithOverlay);

    canvas.drawBitmap(bmp1, new Matrix(), null);
    canvas.drawBitmap(resizedBitmap, ((bmp1.getWidth()/2)-250), ((bmp1.getHeight()/2)-450), null);

    return bitmapWithOverlay;
}
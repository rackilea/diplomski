private Bitmap cropBitmapFromCenterAndScreenSize(Bitmap bitmap) {
    float screenWidth, screenHeight;
    float bitmap_width = bitmap.getWidth(), bitmap_height = bitmap
            .getHeight();
    Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
            .getDefaultDisplay();
    screenWidth = display.getWidth();
    screenHeight = display.getHeight();

    Log.i("TAG", "bitmap_width " + bitmap_width);
    Log.i("TAG", "bitmap_height " + bitmap_height);

    float bitmap_ratio = (float) (bitmap_width / bitmap_height);
    float screen_ratio = (float) (screenWidth / screenHeight);
    int bitmapNewWidth, bitmapNewHeight;

    Log.i("TAG", "bitmap_ratio " + bitmap_ratio);
    Log.i("TAG", "screen_ratio " + screen_ratio);

    if (screen_ratio > bitmap_ratio) {
        bitmapNewWidth = (int) screenWidth;
        bitmapNewHeight = (int) (bitmapNewWidth / bitmap_ratio);
    } else {
        bitmapNewHeight = (int) screenHeight;
        bitmapNewWidth = (int) (bitmapNewHeight * bitmap_ratio);
    }

    bitmap = Bitmap.createScaledBitmap(bitmap, bitmapNewWidth,
            bitmapNewHeight, true);

    Log.i("TAG", "screenWidth " + screenWidth);
    Log.i("TAG", "screenHeight " + screenHeight);
    Log.i("TAG", "bitmapNewWidth " + bitmapNewWidth);
    Log.i("TAG", "bitmapNewHeight " + bitmapNewHeight);

    int bitmapGapX, bitmapGapY;
    bitmapGapX = (int) ((bitmapNewWidth - screenWidth) / 2.0f);
    bitmapGapY = (int) ((bitmapNewHeight - screenHeight) / 2.0f);

    Log.i("TAG", "bitmapGapX " + bitmapGapX);
    Log.i("TAG", "bitmapGapY " + bitmapGapY);

    bitmap = Bitmap.createBitmap(bitmap, bitmapGapX, bitmapGapY,
            screenWidth,screenHeight);
    return bitmap;
}
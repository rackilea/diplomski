public Bitmap getBitmap() {

    setDrawingCacheEnabled(true);
    buildDrawingCache(true);
    final Bitmap bitmap = Bitmap.createBitmap(getDrawingCache());
    setDrawingCacheEnabled(false);

    destroyDrawingCache();
    return bitmap;
}
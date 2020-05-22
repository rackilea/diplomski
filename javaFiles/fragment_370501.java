public Bitmap getBitmap(SurfaceView surfaceView) {

    surfaceView.setDrawingCacheEnabled(true);
    surfaceView.buildDrawingCache(true);
    final Bitmap bitmap = Bitmap.createBitmap(surfaceView.getDrawingCache());
    surfaceView.setDrawingCacheEnabled(false);

    surfaceView.destroyDrawingCache();
    return bitmap;
}
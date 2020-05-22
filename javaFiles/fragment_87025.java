public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    synchronized (holder) {
        Log.view("Surface changed event: width = " + width + ", height = " + height);
        if (width < height) {
            Log.view("HEY THIS IS NOT LANDSCAPE!!!!");
            return;
        }
        // do stuff
    }
}
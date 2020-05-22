class SurfaceHolderCallback implements SurfaceHolder.Callback {
    private static final int IMAGE_WIDTH = 512;
    private static final int IMAGE_HEIGHT = 384;
    private static final String ORIENTATION = "orientation";
    private static final String ROTATION = "rotation";
    private static final String PORTRAIT = "portrait";
    private static final String LANDSCAPE = "landscape";

    public void surfaceCreated(SurfaceHolder holder) {
        try {
            // This case can actually happen if the user opens and closes the camera too frequently.
            // The problem is that we cannot really prevent this from happening as the user can easily
            // get into a chain of activites and tries to escape using the back button.
            // The most sensible solution would be to quit the entire EPostcard flow once the picture is sent.
            camera = Camera.open();
        } catch(Exception e) {
            finish();
            return;
        }

        //Surface.setOrientation(Display.DEFAULT_DISPLAY,Surface.ROTATION_90);
        Parameters p = camera.getParameters();
        p.setPictureSize(IMAGE_WIDTH, IMAGE_HEIGHT);

        camera.getParameters().setRotation(90);

        Camera.Size s = p.getSupportedPreviewSizes().get(0);
        p.setPreviewSize( s.width, s.height );

        p.setPictureFormat(PixelFormat.JPEG);
        p.set("flash-mode", "auto");
        camera.setParameters(p);

        try {
            camera.setPreviewDisplay(surfaceHolder);
        } catch (Throwable ignored) {
            Log.e(APP, "set preview error.", ignored);
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        if (isPreviewRunning) {
            camera.stopPreview();
        }
        try {
            camera.startPreview();
        } catch(Exception e) {
            Log.d(APP, "Cannot start preview", e);    
        }
        isPreviewRunning = true;
    }

    public void surfaceDestroyed(SurfaceHolder arg0) {
        if(isPreviewRunning && camera != null) {
            if(camera!=null) {
                camera.stopPreview();
                camera.release();  
                camera = null;
            }
            isPreviewRunning = false;
        }
    }
}
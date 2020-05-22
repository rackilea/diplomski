SurfaceHolder.Callback surfaceCallback=new SurfaceHolder.Callback() {
    public void surfaceCreated(SurfaceHolder holder) {
        mCamera = Camera.open();
        mCamera.setPreviewDisplay(holder);    
    }

    public void surfaceChanged(SurfaceHolder holder,
                               int format, int width,
                               int height) {
        initPreview(width, height);
        startPreview();

    }
}
public void surfaceChanged(SurfaceHolder holder, int format, int width,
        int height) {

    this.width = width; this.height = height;
    params.setPreviewSize( width, height );
    camera.setParameters( params );
    camera.startPreview();

}
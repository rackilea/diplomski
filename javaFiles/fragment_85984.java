public void surfaceChanged(SurfaceHolder holder, int format, int width,
        int height) {

    Size size = params.getPreviewSize();
    this.height = size.height;
    this.width = size.width;
    camera.setParameters( params );
    camera.startPreview();

}
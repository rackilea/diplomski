public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
    Camera.Parameters param = camera.getParameters();
    List<Camera.Size> previewSizes = param.getSupportedPreviewSizes();
    Camera.Size ps = // .... select a previewSize 
    param.setPreviewSize(ps.width, ps.height);
    camera.setParameters(param);
    camera.startPreview();
}
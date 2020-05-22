SurfaceHolder.Callback surfaceCallback=new SurfaceHolder.Callback() 
{   
    public void surfaceCreated(SurfaceHolder holder) {

        camera.setPreviewCallback(previewCallback);
    }
}
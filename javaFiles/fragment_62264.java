@Override
public void surfaceCreated(SurfaceHolder arg0) {
 try {
    camera = Camera.open();

    parameters = camera.getParameters();
    parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
    parameters.setFocusMode(Parameters.FOCUS_MODE_AUTO);
    camera.setParameters(parameters);
    camera.setPreviewDisplay(holder);
    camera.startPreview();
    camera.autoFocus(new AutoFocusCallback() {

        @Override
        public void onAutoFocus(boolean success, Camera camera) {

        }
    });
    recorder = new MediaRecorder();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}
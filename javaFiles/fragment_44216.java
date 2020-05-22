private void btnFlashOnClick() {

if (mCamera != null) {
                // First get the Camera Parameters.
                Camera.Parameters parameters = mCamera.getParameters();

                // set FlashMode to camera parameters.
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);

                // set Parameters Objects to Camera.
                mCamera.setParameters(parameters);

                // Finally, Start the Preview Of a Camera
                mCamera.startPreview(); // this Line is Usefull for MyApp.If you don't need then Remove this Line.
            }
}
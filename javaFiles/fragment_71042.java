private void loadCameraParameters() {
    final Camera.Parameters camParams = mCamera.getParameters();

    final Camera.Size previewSize = getOptimalPreviewSize(camParams.getSupportedPreviewSizes(),  screenWidth, screenHeight);
    camParams.setPreviewSize(previewSize.width, previewSize.height);

    final Camera.Size pictureSize = getOptimalPreviewSize(camParams.getSupportedPictureSizes(), screenWidth, screenHeight);
    camParams.setPictureSize(pictureSize.width, pictureSize.height);

    mCamera.setParameters(camParams);
}
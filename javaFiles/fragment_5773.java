void setFrontCamera(Camera camera) {
    Camera.Parameters parameters = camera.getParameters();
    parameters.set("camera-id", 2);
    // (800, 480) is also supported front camera preview size at Samsung Galaxy S.
    parameters.setPreviewSize(640, 480); 
    camera.setParameters(parameters);
}
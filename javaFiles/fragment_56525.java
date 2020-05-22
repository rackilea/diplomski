private void setCameraZoomFactor(float pZoomFactor) {
    newZoomFactor = mPinchZoomStartedCameraZoomFactor * pZoomFactor;
    if (newZoomFactor < 1f)
        newZoomFactor = 1f;
    if (newZoomFactor > 1.5f)
        newZoomFactor = 1.5f;

    mZoomCamera.setZoomFactor(newZoomFactor);
}
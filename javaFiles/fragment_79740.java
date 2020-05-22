public void takePicture() {
    try {
        // This is how to tell the camera to lock focus.
        mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, CameraMetadata.CONTROL_AF_TRIGGER_START);
        // Tell #mCaptureCallback to wait for the lock.
        mState = STATE_WAITING_LOCK;
        mCaptureSession.capture(mPreviewRequestBuilder.build(), mCaptureCallback, backgroundHandler);
    } catch (CameraAccessException e) {
        e.printStackTrace();
    }
    Toast.makeText(activity.getApplicationContext(), file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
}
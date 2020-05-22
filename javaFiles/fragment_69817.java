mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE,CaptureRequest.CONTROL_AF_MODE_OFF);
mPreviewRequest = mPreviewRequestBuilder.build();
cameraSession.setRepeatingRequest(mPreviewRequest, mCaptureCallback, backgroundHandler);
mPreviewRequestBuilder.set(CaptureRequest.LENS_FOCUS_DISTANCE, 7.5f);
mPreviewRequest = mPreviewRequestBuilder.build();
cameraSession.setRepeatingRequest(mPreviewRequest, mCaptureCallback, backgroundHandler);
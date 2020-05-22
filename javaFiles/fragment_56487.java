private void updatePreview() {
        if(cameraDevice == null)
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        try{
            captureRequestBuilder.set(CaptureRequest.FLASH_MODE, flashSwitch);
            captureRequestBuilder.set(CaptureRequest.LENS_FOCUS_DISTANCE, focusDistance);    
            cameraCaptureSessions.setRepeatingRequest(captureRequestBuilder.build(),null,mBackgroundHandler);

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
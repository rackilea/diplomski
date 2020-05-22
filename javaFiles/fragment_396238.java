/**
     * Upload a video directly by recording it using camera
     * You can do image/video whatever you require
     */
    private void recordVideo() {
        Intent recordVideoIntent = new Intent();
        recordVideoIntent.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
        if (recordVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(recordVideoIntent, UPLOAD_VIDEO_CAMERA);
        }
    }
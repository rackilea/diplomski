private boolean prepareVideoRecorder() {
    mRecorder = new MediaRecorder();

    // Both are required for Portrait Video
    mCamera.setDisplayOrientation(90);
    if (mCameraId == CAMERA_FACING_FRONT) {
        mRecorder.setOrientationHint(270);
    } else {
        mRecorder.setOrientationHint(90);
    }

    // Step 1: Unlock and set camera to MediaRecorder
    mCamera.unlock();
    mRecorder.setCamera(mCamera);

    // Step 2: Set sources
    mRecorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
    mRecorder.setVideoSource(MediaRecorder.VideoSource.DEFAULT);

    // Step 3: Set a CamcorderProfile (requires API Level 8 or higher)
    mRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_480P));

    // Step 4: Set output file
    final File folder;
    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
        folder = new File(Environment.getExternalStorageDirectory() + "/CameraApp/Videos");
    } else {
        folder = new File(Environment.getExternalStorageDirectory() + "/CameraApp/Videos");
    }

    boolean success = true;
    File videoFile;
    if (!folder.exists()) {
        success = folder.mkdirs();
    }
    if (success) {
        videoFile = new File(folder.getAbsolutePath() + File.separator + getFileNameCustomFormat() + " " + ".mp4");

        SavedVideoPath = getFileNameCustomFormat() + " " + ".mp4";
        Log.e("Video Path - ", SavedVideoPath);
    } else {
        Toast.makeText(getBaseContext(), "Video Not saved", Toast.LENGTH_SHORT).show();
        return true;
    }
    mRecorder.setOutputFile(String.valueOf(videoFile));

    // mRecorder.setVideoSize(mPreviewWidth, mPreviewHeight);

    // Step 5: Set the preview output
    mRecorder.setPreviewDisplay(mSurfaceHolder.getSurface());

    // Step 6: Prepare configured MediaRecorder
    try {
        mRecorder.prepare();
    } catch (IllegalStateException e) {
        Toast.makeText(getApplicationContext(), "prepareVideoRecorder() Exception: " + e.getMessage(), Toast.LENGTH_LONG).show();
        releaseMediaRecorder();
        return false;
    } catch (IOException e) {
        Toast.makeText(getApplicationContext(), "prepareVideoRecorder() Exception: " + e.getMessage(), Toast.LENGTH_LONG).show();
        releaseMediaRecorder();
        return false;
    }
    return true;
}
@Override
protected void onResume() {
    super.onResume();
        mCamAsync = new CameraAsync(this);//Async task to get the camera instance
        mCamAsync.execute();



}



@Override
protected void onPause() {
     super.onPause();
    releaseCameraAndPreview();
        preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.removeViewAt(0);

}
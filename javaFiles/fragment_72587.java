public void takeVideo(){
    Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

    fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO);

    // set video quality
    // 1- for high quality video
    intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
    intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
    // start the video capture Intent
    getParentFragment().startActivityForResult(intent, CAMERA_CAPTURE_VIDEO_REQUEST_CODE);

    Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
    File f = new File(fileUri.getPath());
    Uri contentUri = Uri.fromFile(f);
    mediaScanIntent.setData(contentUri);
    sendBroadcast(mediaScanIntent);

}
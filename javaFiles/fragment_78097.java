private void takePhoto() {
    ArSceneView view = arFragment.getArSceneView();

    // Create a bitmap the size of the scene view.
    final Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),
            Bitmap.Config.ARGB_8888);

    // Create a handler thread to offload the processing of the image.
    final HandlerThread handlerThread = new HandlerThread("PixelCopier");
    handlerThread.start();
    // Make the request to copy.
    PixelCopy.request(view, bitmap, (copyResult) -> {
        if (copyResult == PixelCopy.SUCCESS) {
            try {
                saveBitmapToDisk(bitmap);
            } catch (IOException e) {
                Toast toast = Toast.makeText(VisualizerActivity.this, e.toString(),
                        Toast.LENGTH_LONG);
                toast.show();
                return;
            }
            SnackbarUtility.showSnackbarTypeLong(settingsButton, "Screenshot saved in /Pictures/Screenshots");




        } else {

            SnackbarUtility.showSnackbarTypeLong(settingsButton, "Failed to take screenshot");

        }
        handlerThread.quitSafely();
    }, new Handler(handlerThread.getLooper()));
}


public void saveBitmapToDisk(Bitmap bitmap) throws IOException {

  //  String path = Environment.getExternalStorageDirectory().toString() +  "/Pictures/Screenshots/";

    if (videoDirectory == null) {
        videoDirectory =
                new File(
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                                + "/Screenshots");
    }

    Calendar c = Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
    String formattedDate = df.format(c.getTime());

    File mediaFile = new File(videoDirectory, "FieldVisualizer"+formattedDate+".jpeg");

    FileOutputStream fileOutputStream = new FileOutputStream(mediaFile);
    bitmap.compress(Bitmap.CompressFormat.JPEG, 70, fileOutputStream);
    fileOutputStream.flush();
    fileOutputStream.close();
}
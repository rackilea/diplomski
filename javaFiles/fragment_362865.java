// Create the File where the photo should go
    File photoFile = null;
    try {
        photoFile = createImageFile(context);
    } catch (IOException ex) {
        // Error occurred while creating the File
        Timber.e("Can't create photoFile:%s",ex.getMessage());
    }

private static File createImageFile(Context ctx) throws IOException {
    // Create an image file name
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",Locale.US).format(new Date());
    String imageFileName = "JPEG_" + timeStamp + "_";
    File storageDir = ctx.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    return File.createTempFile(
            imageFileName,  /* prefix */
            ".png",         /* suffix */
            storageDir      /* directory */
    );
}
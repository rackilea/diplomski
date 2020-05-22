file.open(mGoogleApiClient, DriveFile.MODE_READ_ONLY, null)
    .setResultCallback(
      new ResultCallback<DriveApi.DriveContentsResult>() {
        @Override
        public void onResult(DriveApi.DriveContentsResult result) {
        if (!result.getStatus().isSuccess()) {
          // Handle an error
        }
        DriveContents driveContents = result.getDriveContents();
        InputStream is = driveContents.getInputStream();
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        // Do something with the bitmap

        // Don't forget to close the InputStream
        is.close();
      });
bearImage.setDrawingCacheEnabled(true);
    bearImage.buildDrawingCache();
    Bitmap bitmap = bearImage.getDrawingCache();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
    byte[] data = baos.toByteArray();

    // Upload it to our reference
    UploadTask uploadTask = bearRef.putBytes(data);
    buttonDownload.setEnabled(false);
    uploadTask.addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception exception) {
            // Handle unsuccessful uploads
            progressDialog.dismiss();

            Log.w(LOG_TAG, "Upload failed: " + exception.getMessage());
        }
    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
        @Override
        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
            // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
            Uri downloadUrl = taskSnapshot.getDownloadUrl();
            progressDialog.dismiss();

            Log.d(LOG_TAG, "Download Url: " + downloadUrl);
            buttonDownload.setEnabled(true);
        }
    });
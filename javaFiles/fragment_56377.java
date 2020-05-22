MarshMallowPermission marshMallowPermission = new MarshMallowPermission(this);


public void getPhotoFromCamera() {

    if (!marshMallowPermission.checkPermissionForCamera()) {
        marshMallowPermission.requestPermissionForCamera();
    } else {
        if (!marshMallowPermission.checkPermissionForExternalStorage()) {
            marshMallowPermission.requestPermissionForExternalStorage();
        } else {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File mediaStorageDir = new File(
                    Environment.getExternalStorageDirectory()
                            + File.separator
                            + getString(R.string.directory_name_corp_chat)
                            + File.separator
                            + getString(R.string.directory_name_images)
            );

            if (!mediaStorageDir.exists()) {
                mediaStorageDir.mkdirs();
            }

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                    Locale.getDefault()).format(new Date());
            try {
                mediaFile = File.createTempFile(
                        "IMG_" + timeStamp,  /* prefix */
                        ".jpg",         /* suffix */
                        mediaStorageDir      /* directory */
                );
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mediaFile));
                startActivityForResult(takePictureIntent, PICK_FROM_CAMERA);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
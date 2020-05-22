File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
        IMAGE_DIRECTORY_NAME);

if (!mediaStorageDir .exists()) {
        mediaStorageDir.mkdirs();
}   

Intent intent    = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
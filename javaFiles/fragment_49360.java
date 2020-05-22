private void fireIntentToOpenDeviceImageResources() {
    Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    pickIntent.setType("image/*");

    Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    ContentValues values = new ContentValues();
    values.put(MediaStore.Images.Media.TITLE, "New Picture");
    values.put(MediaStore.Images.Media.DESCRIPTION, "From your Camera");
    Uri imageUri = MainActivity.this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
    takePicture.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

    Intent dropboxIntent = new Intent(Intent.ACTION_GET_CONTENT);
    dropboxIntent.setPackage("com.dropbox.android");
    dropboxIntent.setType("image/*");

    Intent chooserIntent = Intent.createChooser(pickIntent, "Select Image");
    chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{takePicture, dropboxIntent});

    startActivityForResult(chooserIntent, GlobalConsts.PICK_IMAGE_REQUEST);
}
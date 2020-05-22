private void openFileChooser(Uri uri) {
    Intent intent = new Intent();
    intent.setType("image/*");
    intent.setAction(Intent.ACTION_GET_CONTENT);
    if (uri == mProfilePic) {
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    } else if (uri == mIdPhoto) {
        startActivityForResult(intent, PICK_IMAGE_REQUEST_ID);
    } else if (uri == mCriminalRecord) {
        startActivityForResult(intent, PICK_IMAGE_REQUEST_CR);
    }
}
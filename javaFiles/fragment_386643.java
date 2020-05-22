private void selectImage() {
    final CharSequence[] items = { getString(R.string.take_photo), getString(R.string.choose_from_gallery),
            getString(R.string.cancel) };

    AlertDialog.Builder builder = new AlertDialog.Builder(MyAccountActivity.this);
    builder.setTitle(getString(R.string.upload_photo));
    builder.setItems(items, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int item) {
            if (items[item].equals(getString(R.string.take_photo))) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CAMERA);
            } else if (items[item].equals(getString(R.string.choose_from_gallery))) {
                Intent intent = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(
                        Intent.createChooser(intent, getString(R.string.select_file)),
                        SELECT_FILE);
            } else if (items[item].equals(getString(R.string.choose_from_gallery))) {
                dialog.dismiss();
            }
        }
    });
    builder.show();
}
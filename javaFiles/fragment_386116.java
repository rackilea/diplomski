@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    try {

        if (requestCode == IMG_RESULT && resultCode == RESULT_OK
                && null != data) {
            imageViewLoad.setImageBitmap(BitmapFactory
                    .decodeStream(getContentResolver().openInputStream(data.getData()));

        }
    } catch (Exception e) {
        Toast.makeText(this, "Please try again", Toast.LENGTH_LONG)
                .show();
    }

}
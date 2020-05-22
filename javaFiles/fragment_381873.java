@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode == RESULT_OK) {
        if (requestCode == Constants.PICK_USER_PROFILE_IMAGE) {
            if (resultCode == RESULT_OK) {
                Bitmap bmp = ImagePicker.getImageFromResult(this, resultCode, data);//your compressed bitmap here
                startPosting(bmp);
            }
        }
    }
}
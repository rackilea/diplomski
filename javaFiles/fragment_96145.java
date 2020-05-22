@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if ( resultCode == RESULT_OK && null != data) {
        Uri selectedImage = data.getData();





        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

         Bitmap resized = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
              imageView.setImageBitmap(ProfilePicture.getRoundedRectBitmap(resized));



    }


}
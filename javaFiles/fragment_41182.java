@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (resultCode != RESULT_OK) {
        return;
    }
    Bitmap bitmap;

    switch (requestCode) {

        case REQUEST_CODE_GALLERY:
            try {
                Uri uri = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    Bitmap bitmapScaled = Bitmap.createScaledBitmap(bitmap, 800, 800, true);
                    Drawable drawable=new BitmapDrawable(bitmapScaled);
                    mImage.setImageDrawable(drawable);
                    mImage.setVisibility(View.VISIBLE);
                    mImageString=HelperUtils.encodeTobase64(bitmap);
                } catch (IOException e) {
                    Log.v("galeri", "hata var : "+e.getMessage());
                }
            } catch (Exception e) {
                Log.v("kamera", "hata var : "+e.getMessage());
            }
            break;
        case REQUEST_CODE_TAKE_PICTURE:
            bitmap = (Bitmap) data.getExtras().get("data");
            mImage.setImageBitmap(bitmap);
            mImage.setVisibility(View.VISIBLE);
            mImageString=HelperUtils.encodeTobase64(bitmap);
            break;
    }
    super.onActivityResult(requestCode, resultCode, data);
}
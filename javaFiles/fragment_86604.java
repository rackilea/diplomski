public void onClick(View view) {
    Intent shareIntent = new Intent();
    shareIntent.setAction(Intent.ACTION_SEND);
    shareIntent.setType("image/png");
    ImageView imageView = (ImageView) view;

    Drawable mDrawable = imageView.getDrawable();
    Bitmap mBitmap = ((BitmapDrawable) mDrawable).getBitmap();

    String path = MediaStore.Images.Media.insertImage(mContext.getContentResolver(), mBitmap, "Image Description", null);
    Uri uri = Uri.parse(path);
    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
    startActivity(Intent.createChooser(shareIntent, "Share Content!!"));

}
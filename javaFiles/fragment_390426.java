private void setBitmap(final ImageView iv, final int id) {
    byte[] byteArray = 
        bitmapToByte(MediaStore.Images.Thumbnails.getThumbnail(getApplicationContext().getContentResolver(), id, MediaStore.Images.Thumbnails.MICRO_KIND, null);

    Glide.with(this).load(byteArray.asBitmap().into(iv);
}

private byte[] bitmapToByte(Bitmap bitmap){
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
    byte[] byteArray = stream.toByteArray();
    return byteArray;
}
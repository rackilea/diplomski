public Uri getUri(Context context, Bitmap imgBitmap) {
  ByteArrayOutputStream bOutputStream = new ByteArrayOutputStream();
  String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), 
  imgBitmap, "Title", null);

  return Uri.parse(path);
}
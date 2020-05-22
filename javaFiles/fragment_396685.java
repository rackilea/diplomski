private String getRealPathFromContentUri(Context context, Uri contentURI) {
    String result = null;
    Cursor cursor = context.getContentResolver().query(contentURI, null, null, null, null);
    if (cursor == null) {
      try {
        result = contentURI.getPath();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      cursor.moveToFirst();
      int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
      try {
        result = cursor.getString(idx);
        cursor.close();
      } catch (IllegalStateException e) {
        e.printStackTrace();
        return null;
      }
    }
    return result;
}
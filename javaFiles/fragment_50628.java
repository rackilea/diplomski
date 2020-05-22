public static ArrayList<String> getImagesFromGallery(Activity activity) {
     Uri uri;
     Cursor cursor;
     int column_index_data, column_index_folder_name;
     ArrayList<String> listOfAllImages = new ArrayList<String>();
     String absolutePathOfImage = null;
     uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

     String[] projection = { MediaColumns.DATA,
        MediaStore.Images.Media.BUCKET_DISPLAY_NAME };

     cursor = activity.getContentResolver().query(uri, projection, null,
        null, null);

     column_index_data = cursor.getColumnIndexOrThrow(MediaColumns.DATA);
     column_index_folder_name = cursor
        .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
     while (cursor.moveToNext()) {
    absolutePathOfImage = cursor.getString(column_index_data);

     listOfAllImages.add(absolutePathOfImage);
    }
     return listOfAllImages;
 }
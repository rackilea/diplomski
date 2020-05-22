public String getPathFromURI(Context context, Uri contentUri) {
   Cursor mediaCursor = null;
   try { 
           String[] dataPath = { MediaStore.Images.Media.DATA };
           mediaCursor = context.getContentResolver().query(contentUri,  dataPath, null, null, null);
           int column_index = mediaCursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
           mediaCursor.moveToFirst();
           return mediaCursor.getString(column_index);
   } finally {
       if (mediaCursor != null) {
             mediaCursor.close();
       }
   }
}
String[] projection = { 
          MediaStore.Images.ImageColumns._ID, MediaStore.Images.ImageColumns.DATA 
}; 
String selection = ""; 
String[] selectionArgs = null; 
mImageExternalCursor = managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
           projection, selection, selectionArgs, null); 
mImageInternalCursor = 
           managedQuery(MediaStore.Images.Media.INTERNAL_CONTENT_URI, projection,
           selection, selectionArgs, null);
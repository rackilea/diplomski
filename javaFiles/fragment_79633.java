public String getRealPath(Uri uri) {
    String [] proj={MediaStore.Images.Media.DATA};
    Cursor cursor = getContentResolver().query(uri, proj,  null, null, null);
    int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
    cursor.moveToFirst();
    String path = cursor.getString(column_index); 
    cursor.close();

    return path;
}
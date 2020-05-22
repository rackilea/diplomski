String path = context.getFilesDir().toString();
String fileName = cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_PRODUCT_ID));

if (fileName != null && !fileName.equals("")) {
    Bitmap bMap = BitmapFactory.decodeFile(path + "/" + fileName);
    if (bMap != null) {
        thumbnail.setImageBitmap(bMap);
    }
}
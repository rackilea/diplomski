public static void handleImageRotation(Context context, File mFileTemp) {

    if (!mFileTemp.exists()) {
        Toast.makeText(context, "File not found", Toast.LENGTH_SHORT).show();
        return;
    }


    ExifInterface exif = null;
    int orientation = ExifInterface.ORIENTATION_NORMAL;
    try {
        exif = new ExifInterface(mFileTemp.getAbsolutePath());

        orientation = exif.getAttributeInt(
                ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_NORMAL);
    } catch (Exception e) {
        e.printStackTrace();
    }

    Bitmap temp = BitmapFactory.decodeFile(mFileTemp.getAbsolutePath());

    if (temp == null) Log.e(TAG, "Bitmap from File is null");

    Matrix matrix = new Matrix();

    if (orientation == ExifInterface.ORIENTATION_ROTATE_90) {
        matrix.postRotate(90);
        temp = Bitmap.createBitmap(temp, 0, 0, temp.getWidth(), temp.getHeight(), matrix, true);
    } else if (orientation == ExifInterface.ORIENTATION_ROTATE_180) {
        matrix.postRotate(180);
        temp = Bitmap.createBitmap(temp, 0, 0, temp.getWidth(), temp.getHeight(), matrix, true);
    } else if (orientation == ExifInterface.ORIENTATION_ROTATE_270) {
        matrix.postRotate(270);
        temp = Bitmap.createBitmap(temp, 0, 0, temp.getWidth(), temp.getHeight(), matrix, true);
    }

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    temp.compress(Bitmap.CompressFormat.JPEG, 40, bos);

    byte[] bitmapdata = bos.toByteArray();

    // write the bytes in file
    try {
        FileOutputStream fos = new FileOutputStream(mFileTemp);
        fos.write(bitmapdata);
        fos.flush();
        fos.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
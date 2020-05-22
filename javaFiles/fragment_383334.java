public static Bitmap getResizedBitmap(Bitmap image, int newHeight, int newWidth) {
    int width = image.getWidth();
    int height = image.getHeight();
    float scaleWidth = ((float) newWidth) / width;
    float scaleHeight = ((float) newHeight) / height;
    // create a matrix for the manipulation
    Matrix matrix = new Matrix();
    // resize the bit map
    matrix.postScale(scaleWidth, scaleHeight);
    // recreate the new Bitmap
    Bitmap resizedBitmap = Bitmap.createBitmap(image, 0, 0, width, height,
            matrix, false);
    return resizedBitmap;
}
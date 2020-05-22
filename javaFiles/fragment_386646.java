private static Bitmap handleSamplingAndRotationBitmap(Context context, Uri selectedImage) throws IOException {
    int MAX_HEIGHT = 1024;
    int MAX_WIDTH = 1024;

    final BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    InputStream imageStream = context.getContentResolver().openInputStream(selectedImage);
    BitmapFactory.decodeStream(imageStream, null, options);
    imageStream.close();

    // Calculate inSampleSize
    options.inSampleSize = calculateInSampleSize(options, MAX_WIDTH, MAX_HEIGHT);

    // Decode bitmap with inSampleSize set
    options.inJustDecodeBounds = false;
    imageStream = context.getContentResolver().openInputStream(selectedImage);
    Bitmap img = BitmapFactory.decodeStream(imageStream, null, options);

    img = rotateImageIfRequired(img, selectedImage);
    return img;
}

private static int calculateInSampleSize(BitmapFactory.Options options,
                                         int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        // Calculate ratios of height and width to requested height and width
        final int heightRatio = Math.round((float) height / (float) reqHeight);
        final int widthRatio = Math.round((float) width / (float) reqWidth);

        // Choose the smallest ratio as inSampleSize value, this will guarantee a final image
        // with both dimensions larger than or equal to the requested height and width.
        inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;

        // This offers some additional logic in case the image has a strange
        // aspect ratio. For example, a panorama may have a much larger
        // width than height. In these cases the total pixels might still
        // end up being too large to fit comfortably in memory, so we should
        // be more aggressive with sample down the image (=larger inSampleSize).

        final float totalPixels = width * height;

        // Anything more than 2x the requested pixels we'll sample down further
        final float totalReqPixelsCap = reqWidth * reqHeight * 2;

        while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
            inSampleSize++;
        }
    }
    return inSampleSize;
}

private static Bitmap rotateImageIfRequired(Bitmap img, Uri selectedImage) throws IOException {

    ExifInterface ei = new ExifInterface(selectedImage.getPath());
    int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

    switch (orientation) {
        case ExifInterface.ORIENTATION_ROTATE_90:
            return rotateImage(img, 90);
        case ExifInterface.ORIENTATION_ROTATE_180:
            return rotateImage(img, 180);
        case ExifInterface.ORIENTATION_ROTATE_270:
            return rotateImage(img, 270);
        default:
            return img;
    }
}

private static Bitmap rotateImage(Bitmap img, int degree) {
    Matrix matrix = new Matrix();
    matrix.postRotate(degree);
    Bitmap rotatedImg = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, true);
    img.recycle();
    return rotatedImg;
}
private static Bitmap ShrinkBitmap(String backgroundimage, int width,
        int height) {

    // TODO Auto-generated method stub
    BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
    bmpFactoryOptions.inJustDecodeBounds = true;
    Bitmap bitmap = BitmapFactory.decodeFile(backgroundimage,
            bmpFactoryOptions);

    int heightRatio = (int) Math.ceil(bmpFactoryOptions.outHeight
            / (float) height);
    int widthRatio = (int) Math.ceil(bmpFactoryOptions.outWidth
            / (float) width);

    if (heightRatio > 1 || widthRatio > 1) {
        if (heightRatio > widthRatio) {
            bmpFactoryOptions.inSampleSize = heightRatio;
        } else {
            bmpFactoryOptions.inSampleSize = widthRatio;
        }
    }

    bmpFactoryOptions.inJustDecodeBounds = false;
    bitmap = BitmapFactory.decodeFile(backgroundimage, bmpFactoryOptions);
    return bitmap;

}
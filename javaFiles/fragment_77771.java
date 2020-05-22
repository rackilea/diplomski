public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
    int reqWidth, int reqHeight) {

// First decode with inJustDecodeBounds=true to check dimensions
final BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
BitmapFactory.decodeResource(res, resId, options);

// Calculate inSampleSize
options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

// Decode bitmap with inSampleSize set
options.inJustDecodeBounds = false;
return BitmapFactory.decodeResource(res, resId, options);
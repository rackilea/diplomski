BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
BitmapFactory.decodeByteArray(base64converted,0,base64converted.length,options);

// Calculate inSampleSize
options.inSampleSize = calculateInSampleSize(options, 500, 500);
// Decode bitmap with inSampleSize set
options.inJustDecodeBounds = false;
Bitmap bmp1=BitmapFactory.decodeByteArray(base64converted,0,base64converted.length,options);
ExifInterface exif = new ExifInterface(file);
int oridentation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
switch(orientation) {
    case ExifInterface.ORIENTATION_ROTATE_90:
       //do what you want
       break;
    case ExifInterface.ORIENTATION_ROTATE_180:
       //do what you want
       break;
    ....
}
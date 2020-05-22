ExifInterface exif = null;
try {
    exif = new ExifInterface(path);
} catch (IOException e) {
    e.printStackTrace();
}  
int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 
                                       ExifInterface.ORIENTATION_UNDEFINED);
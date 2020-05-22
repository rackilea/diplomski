private void storeImage(Bitmap image) {
File pictureFile = getOutputMediaFile();
if (pictureFile == null) {
    Log.d(TAG,
            "Error creating media file, check storage permissions: ");// e.getMessage());
    return;
} 
try {
    FileOutputStream fos = new FileOutputStream(pictureFile);
    image.compress(Bitmap.CompressFormat.PNG, 90, fos);
    fos.close();
} catch (FileNotFoundException e) {
    Log.d(TAG, "File not found: " + e.getMessage());
} catch (IOException e) {
    Log.d(TAG, "Error accessing file: " + e.getMessage());
} }
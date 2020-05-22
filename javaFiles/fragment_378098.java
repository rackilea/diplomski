private void createDirectoryAndSaveFile(String name, Bitmap bitmap) {

File folder = new File(Environment.getExternalStorageDirectory() +
        File.separator + "XYZ APP");//here you have created different name
boolean success = true;
if (!folder.exists()) {
    success = folder.mkdirs();
}
if (success) {
    // Do something on success

} else {
    // Do something else on failure
}

File photo = new File(folder.getAbsolutePath(), name+ ".jpg"); 
if (photo.exists()) {
    photo.delete();
}
try {
    FileOutputStream out = new FileOutputStream(photo.getPath());
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
    out.flush();
    out.close();
} catch (Exception e) {
    e.printStackTrace();
}
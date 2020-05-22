/**
 * @return the File from the given filename.
 */
public static File getImageFile(String filename) {
    if (!isExternalStorageReadable()) return null;
    // The images folder path.
    String imagesFolder = Environment.getExternalStorageDirectory().getPath()
                          + "Android/data/your.app.package/images/";
    // Creating the file.
    File file = new File(imagesFolder + filename);        
    return file;
}

/**
 * Write the contents of the HTTP entity to the external 
 * storage if available and writable.
 */
public static boolean storeImage(HttpEntity entity, String filename) throws IOException     {
    if (isExternalStorageAvailable()) {
        File file = getImageFile(filename);
        if (file == null) return false;
        // Write to file output stream.
        FileOutputStream os = new FileOutputStream(file);
        entity.writeTo(os);
        os.close();
        return true;
    }
    return false;
}
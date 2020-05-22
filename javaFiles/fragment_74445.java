public boolean fileExists(Context context, String filename) {    
    File file = context.getFileStreamPath(filename);
    if(file == null || !file.exists()) {
        return false;
    }
    return true;
}
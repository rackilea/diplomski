private Bitmap readFromInternalStorage(String filename){
    try {
        File filePath = this.getFileStreamPath(filename);
        FileInputStream fi = new FileInputStream(filePath);
        return BitmapFactory.decodeStream(fi);
    } catch (Exception ex) { /* do nothing here */}

    return null;
}
public StreamedContent getFileStreamedContent() {
    try {
        InputStream is = new BufferedInputStream(
           new FileInputStream("/your/file/path/fileXYZ.jpg"));
        return new DefaultStreamedContent(is, "image/jpeg", "fileXYZ.jpg");
    } catch (FileNotFoundException e) {
    }
}
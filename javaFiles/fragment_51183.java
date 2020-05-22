public void save(FileUploadEvent e) {
    FileUpload file = event.getFile();
    String fileName = file.getFileName();
    String contentType = file.getContentType();
    byte[] content = file.getContents();
    saveFile(content);
}

private void saveFile(byte[] data) {
    FileOutputStream fos = new FileOutputStream(DIR_NAME);
    fos.write(data);
    fos.close();
}
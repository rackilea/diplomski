public byte[] downloadFile(int id) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    FileUploadModel fm =mapper.downloadFile(id);
    InputStream inputStream = fm.getDaFile();
    int read = 0;
    byte[] bytes = new byte[1024];

    while ((read = inputStream.read(bytes)) != -1) {
        out.write(bytes, 0, read);
    }
    return out.toByteArray();
}
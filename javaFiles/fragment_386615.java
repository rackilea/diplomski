InputStream is = conn.getInputStream();
byte[] buffer = new byte[10240]; // 10K is a 'reasonable' amount

try {
    File newFile = newFile("/some/path/file.mp3");
    FileOutputStream fos = new FileOutputStream(newFile);

    int len = 0;
    while ((len = is.read(buffer)) >= 0) {
        fos.write(buffer, 0, len);
    }
    fos.close();
} catch (IOException iox) {
    //do
}
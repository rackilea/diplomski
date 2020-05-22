String source = "smb://SERVER/PATH/FILE";
    NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, "USERNAME", "PASSWORD");
    SmbFile sourceFile = new SmbFile(source, auth);
    String destination = "LOCAL_PATH_TO_FILE";

    byte[] buffer;
    int length;

    try {
        FileOutputStream fileOutputStream = new FileOutputStream(destination);
        InputStream fileInputStream = sourceFile.getInputStream();
        try {
            buffer = new byte[16 * 1024 * 1024];
            while ((length = fileInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }
        } finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    } catch (SmbException e) {
        // Error handling.    
    } catch (FileNotFoundException e) {
        // Error handling.
    } catch (IOException e) {
        // Error handling.
    }
Promise<File> filePromise = WS.url("http://stackoverflow.com/questions/26967252/how-to-get-java-io-file-by-using-play-ws").get().map((r) -> {
    FileOutputStream out = null;
    File file = File.createTempFile("file", null);
    try {
        out = new FileOutputStream(file);
        InputStream bodyAsStream = r.getBodyAsStream();
        byte[] barr = new byte[8 * 1024];
        int read = 0;
        while ((read = bodyAsStream.read(barr)) != -1) {
            out.write(barr, 0, read);
        }
    } finally {
        if (out != null) {
            out.close();
        }
    }
    return file;
});

filePromise.map((file) -> {
    // Use amazon service to upload.
    return file;
});
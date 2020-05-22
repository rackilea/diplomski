public static File doThing(InputStream is) throws IOException {
    File tmp = null;
    FileOutputStream tmpOs = null;
    try {
        tmp = File.createTempFile("xml", "tmp");
        tmpOs = new FileOutputStream(tmp);
        int len = -1;
        byte[] b = new byte[4096];
        while ((len = is.read(b)) != -1) {
            tmpOs.write(b, 0, len);
        }
    } finally {
        try { is.close(); } catch (Exception e) {}
        try { tmpOs.close(); } catch (Exception e) {}
    }
    return tmp;
}
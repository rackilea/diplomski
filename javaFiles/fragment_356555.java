public static boolean ungunzip(String compressedFile,
        String decompressedFile) {
    final int BUFFER_SIZE = 32768;
    try (InputStream in = new GZIPInputStream(new BufferedInputStream(
            new FileInputStream(compressedFile)), BUFFER_SIZE);
            OutputStream out = new BufferedOutputStream(
                    new FileOutputStream(decompressedFile), BUFFER_SIZE)) {
        int n = 0;
        byte[] buffer = new byte[BUFFER_SIZE];
        while ((n = in.read(buffer, 0, BUFFER_SIZE)) > 0) {
            out.write(buffer, 0, n);
        }
        return true;
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}
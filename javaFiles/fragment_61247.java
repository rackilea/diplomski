public static void writeBytes(byte[] in, File file, boolean append) throws IOException {
    FileOutputStream fos = null;
    try {
        fos = new FileOutputStream(file, append);
        fos.write(in);
    } finally {
        if (fos != null)
            fos.close();
    }
}
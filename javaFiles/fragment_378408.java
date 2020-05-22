public static String getDocLength(File f) throws IOException {
    FileInputStream stream = new FileInputStream(f);
    try {
        FileChannel fc = stream.getChannel();
        MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

        String doc = Charset.defaultCharset().decode(bb).toString();
        int length  = doc.length();
        return Integer.toString(length);
    } finally {
        stream.close();
    }
}
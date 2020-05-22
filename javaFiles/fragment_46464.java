public static String streamToString(final InputStream is, final int bufferSize) throws Exception {
    final char[] buffer = new char[bufferSize];
    final StringBuilder out = new StringBuilder();
    try (Reader in = new InputStreamReader(is, "UTF-8")) {
        int rsz = 0;
        while ((rsz = in.read(buffer, 0, buffer.length)) > 0) {
            out.append(buffer, 0, rsz);
        }
    }
    return out.toString();
}
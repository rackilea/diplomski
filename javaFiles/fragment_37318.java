private final static void copyInputStream(InputStream in, OutputStream out)
        throws IOException {
    byte[] buff = new byte[4096];
    int n;
    while ((n = in.read(buff)) > 0) {
        out.write(buff, 0, n);
    }
    out.flush();
    out.close();
    in.close();
}
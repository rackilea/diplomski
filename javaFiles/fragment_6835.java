final byte[] buf = new byte[8192]; // or other

try (
    final InputStream in = theSocket.getInputStream();
    final OutputStream out = whatever();
) {
    int nrBytes;
    while ((nrBytes = in.read(buf)) != -1)
        out.write(buf, 0, nrBytes);
}
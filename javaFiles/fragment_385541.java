public void copy(final InputStream in, final OutputStream out) {
    byte[] buffer = new byte[1024]; 
    int count;

    while ((count = in.read(buffer)) != -1) {
        out.write(buffer, 0, count);
    }

    // Flush out stream, to write any remaining buffered data
    out.flush();
}
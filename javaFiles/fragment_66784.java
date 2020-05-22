InputStream stream = geoLocRetriever.openStream();
ByteArrayOutputStream buffer = new ByteArrayOutputStream();
if (stream != null) try {
    final BufferedInputStream input = new BufferedInputStream(stream);
    final byte[] reader = new byte[16384];
    int r = 0;
    while ((r = input.read(reader, 0, 16384)) != -1)
        buffer.write(reader, 0, r);
    buffer.flush();
} catch(IOException e) {
    e.printStackTrace();
} finally {
    if(stream != null) try {
        stream.close();
    } catch(IOException e) {
        e.printStackTrace();
    }
}
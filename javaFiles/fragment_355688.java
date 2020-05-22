final byte[] buf = new byte[1024]; // or other
final URL url = Start.class.getResource("whatever");
// check for url == null

InputStream in;
ByteArrayOutputStream out;

// I really wish this syntax was something else, it sucks
try (
    in = url.openStream();
    out = new ByteArrayOutputStream();
) {
    int count;
    while ((count = in.read(buf)) != -1)
        out.write(buf, 0, count);
    out.flush();
} catch (IOException e) {
    // handle e here
}

final ByteBuffer buffer = ByteBuffer.wrap(out.toByteArray());
// use the buffer
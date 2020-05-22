byte[] bytes = getBytes(item.openStream());
InputStream stream = new ByteArrayInputStream(bytes);

public static byte[] getBytes(InputStream is) throws IOException {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    int len;
    byte[] data = new byte[100000];
    while ((len = is.read(data, 0, data.length)) != -1) {
    buffer.write(data, 0, len);
    }

    buffer.flush();
    return buffer.toByteArray();
}
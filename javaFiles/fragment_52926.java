ByteArrayOutputStream baos = new ByteArrayOutputStream();
byte[] buf = new byte[8192];
for (;;) {
    int nread = in.read(buf, 0, buf.length);
    if (nread <= 0) {
        break;
    }
    baos.write(buf, 0, nread);
}
in.close();
baos.close();
byte[] bytes = baos.toByteArray();
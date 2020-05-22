ByteArrayOutputStream baos = new ByteArrayOutputStream();
byte[] buf = new byte[8192];
int len = 0;
while ((len = in.read(buf)) != -1) {
    baos.write(buf, 0, len);
}
String body = new String(baos.toByteArray(), encoding);
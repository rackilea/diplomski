byte[] buffer = new byte[BUFFER_SIZE];
ByteArrayOutputStream baos = new ByteArrayOutputStream();
while (!deflater.finished()) {
  int n = deflater.deflate(buffer);
  baos.write(buffer, 0, n);
}
return baos.toByteArray();
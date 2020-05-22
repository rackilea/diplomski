URL url = new URL(imagePath);
ByteArrayOutputStream output = new ByteArrayOutputStream();
URLConnection conn = url.openConnection();
conn.setRequestProperty("User-Agent", "Firefox");

try (InputStream inputStream = conn.getInputStream()) {
  int n = 0;
  byte[] buffer = new byte[1024];
  while (-1 != (n = inputStream.read(buffer))) {
    output.write(buffer, 0, n);
  }
}
byte[] img = output.toByteArray();
ByteBuffer imageBytes = ByteBuffer.wrap(img);
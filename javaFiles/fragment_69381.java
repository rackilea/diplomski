final int BUFFER_SIZE = 32;
ByteArrayInputStream is = new ByteArrayInputStream(compressed);
GZIPInputStream gis = new GZIPInputStream(is, BUFFER_SIZE);
ByteArrayOutputStream baos = new ByteArrayOutputStream();
byte[] data = new byte[BUFFER_SIZE];
int bytesRead;
while ((bytesRead = gis.read(data)) != -1) {
    baos.write(data, 0, bytesRead);
}
gis.close();
return baos.toString("UTF-8"); // Or "Windows-1251" ...
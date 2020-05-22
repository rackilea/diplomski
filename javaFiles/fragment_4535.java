InputStream input = connection.getInputStream();
ByteArrayOutputStream baos = new ByteArrayOutputStream();
byte[] buffer = new byte[1024];
int n;
while ((n = input.read(buffer)) > 0) {
    baos.write(buffer, 0, n);
}
byte[] zippedData = baos.toByteArray();
System.out.println(zippedData.length);
serverExchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/octet-stream");

final File file = new File("/location/to/your/file");
final OutputStream outputStream = serverExchange.getOutputStream();
final InputStream inputStream = new FileInputStream(file);

byte[] buf = new byte[8192];
int c;
while ((c = inputStream.read(buf, 0, buf.length)) > 0) {
    outputStream.write(buf, 0, c);
    outputStream.flush();
}

outputStream.close();
inputStream.close();
InputStream is = connection.getInputStream();

int bytesRead = -1;
byte[] buffer = new byte[1024];
while ((bytesRead = is.read(buffer)) >= 0) {
  // process the buffer, "bytesRead" have been read, no more, no less
}
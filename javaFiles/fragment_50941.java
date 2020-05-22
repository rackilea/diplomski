// server code
byte[] buffer = new byte[4096];
int bytesRead;
while ((bytesRead = in.read(buffer)) > -1) {
  // do something
}
int read = 0;
byte[] buffer = new byte[32768];
while( (read = is.read(buffer)) > 0) {
  fos.write(buffer, 0, read);
}

fos.close();
is.close();
URL target = // whatever;
URLConnection connection = target.openConnection();
connection.setReadTimeout(timeoutInMilliseconds);
InputStream stream;
try {
  stream = connection.getInputStream();
  return ImageIO.read(stream);
} finally {
  if (stream != null) { stream.close(); } 
}
URLConnection connection = url.openConnection();
InputStream stream = connection.getInputStream();
if ("gzip".equals(connection.getContentEncoding())) {
  stream = new GZIPInputStream(stream));
}
InputSource is = new InputSource(stream);
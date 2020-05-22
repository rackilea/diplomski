String entity = "{\"firstname\":\"John\",\"lastname\":\"Doe\"}";

ByteArrayOutputStream baos = new ByteArrayOutputStream();
GZIPOutputStream gzos = new GZIPOutputStream(baos);
gzos.write(entity.getBytes("UTF-8"));
gzos.close();

URLConnection connection = new URL("http://whatever").openConnection();
connection.setDoOutput(true);
connection.setRequestProperty("Content-Type", "application/json");
connection.setRequestProperty("Content-Encoding", "gzip");
connection.connect();
baos.writeTo(connection.getOutputStream());
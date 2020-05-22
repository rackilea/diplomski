URL url = new URL(sourceFileWebAddress);
URLConnection connection = url.openConnection();
connection.connect();

int fileLenth = connection.getContentLength();

InputStream inputStream = url.openStream();
BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
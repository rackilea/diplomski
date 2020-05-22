URL url = new URL("http://www.mydomain.com/slug");
URLConnection urlConnection = url.openConnection();
InputStream in = new BufferedInputStream(urlConnection.getInputStream());
try {
 readStream(in);
} finally {
 in.close();
}
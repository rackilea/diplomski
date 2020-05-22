URL url = new URL("http://www.yourserver.com/some/path");
HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

try { 
    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
    FileOutputStream out = new FileutputStream("/path/to/your/output/file"); 
    byte[] buffer = new byte[16384];
    int len;
    while((len = in.read(buffer)) != -1){
        out.write(buffer, 0, len);
    }
finally {
    urlConnection.disconnect();
}
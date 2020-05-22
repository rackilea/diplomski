Integer var = 97320;
InputStream inputStream = new URL("http://myserver.com/cgi-bin/myfile.pl?var=" + var).openStream();
try {
  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
  // Or this if you returned utf-8 from your service
  //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
  JSONObject json = new JSONObject(readAll(bufferedReader));
} catch (Exception e) {

}
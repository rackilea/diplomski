URL urlApi = new URL(requestUrl);
HttpURLConnection httpURLConnection = (HttpURLConnection) urlApi.openConnection();
httpURLConnection.setRequestMethod(<requestMethod>); // GET or POST
httpURLConnection.setDoOutput(true);
//in case HTTP POST method un-comment following to write request body
//DataOutputStream ds = new DataOutputStream(httpURLConnection.getOutputStream());
//ds.writeBytes(body);
InputStream content = (InputStream) httpURLConnection.getInputStream();
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content));
StringBuilder stringBuilder = new StringBuilder(100);
String line = null;
while ((line = bufferedReader.readLine()) != null) {
    stringBuilder.append(line);
}
String serverResult = stringBuilder.toString();
//now you have a string representation of the server result page
//do what you need
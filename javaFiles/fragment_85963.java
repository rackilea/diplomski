HttpClient client = new DefaultHttpClient();
HttpGet request = new HttpGet();
request.setURI(new URI("http://www.codinggreenrobots.com"));

HttpResponse response = client.execute(request);

BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
StringBuffer sb = new StringBuffer("");
String line = "";
while ((line = in.readLine()) != null) {
    sb.append(line + "\n";
}
in.close();
str_response = sb.toString();
HttpClient client = new DefaultHttpClient();
HttpGet request = new HttpGet(url);

HttpResponse response = client.execute(request);


BufferedReader rd = new BufferedReader(
    new InputStreamReader(response.getEntity().getContent()));

StringBuffer result = new StringBuffer();
String line = "";
while ((line = rd.readLine()) != null) {
    result.append(line);
}
     return result.toString();
public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {

    HttpUriRequest request = new HttpGet(url);
    request.addHeader("Accept-Encoding", "gzip");
    HttpClient httpClient = new DefaultHttpClient();
    HttpResponse response = httpClient.execute(request);

    InputStream instream = response.getEntity().getContent();
    org.apache.http.Header contentEncoding = response.getFirstHeader("Content-Encoding");

    JSONObject json = null;
    if (contentEncoding != null && contentEncoding.getValue().equalsIgnoreCase("gzip")) {
        BufferedReader rd = new BufferedReader(new InputStreamReader(new GZIPInputStream(instream)));
        String jsonText = readAll(rd);
          if (jsonText.contains("</div>")) {
              json = new JSONObject(jsonText.split("</div>")[1]);
          } else {
              json = new JSONObject(jsonText);
          }
    }
    return json;
}
public static String connectionGet(String url, String parameter) throws MalformedURLException, ProtocolException, IOException {

    URL url1 = new URL(url);
    HttpURLConnection request1 = (HttpURLConnection) url1.openConnection();
    request1.setRequestMethod("GET");
    request1.connect();
    String responseBody = convertStreamToString(request1.getInputStream());
    return responseBody;
}

String str = connectionGet("http://www.cleartrip.com/common/json/airports.json", "");
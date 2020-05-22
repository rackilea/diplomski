final String uri = "http://www.example.com";
final String body = String.format("{\"login\": {\"Email\": \"%s\", \"Passwd\": \"%s\"}", "me@email.com", "password");

final HttpClient client = new DefaultHttpClient();
final HttpPost postMethod = new HttpPost(uri);
postMethod.setEntity(new StringEntity(body, "utf-8"));

try {
    final HttpResponse response = client.execute(postMethod);
    final String responseData = EntityUtils.toString(response.getEntity(), "utf-8");
} catch(final Exception e) {
    // handle exception here
}
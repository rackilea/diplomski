public String getToken() throws Exception {

HttpClient clientToken = HttpClients.custom()
    .setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build())
    .build();
String OAuthToken = "";
String urlToken = "";
HttpPost httpPost = new HttpPost(urlToken);

JsonObject jsonCredentials = Json.createObjectBuilder().add("userId", "ad")
    .add("password", "ad").build();

StringEntity entity = new StringEntity(jsonCredentials.toString());
httpPost.setEntity(entity);
HttpResponse response = clientToken.execute(httpPost);

if (response.getStatusLine().getStatusCode() == 201) {

  BufferedReader br = new BufferedReader(
      new InputStreamReader(response.getEntity().getContent()));
  String output = br.readLine();

  if (!output.isEmpty()) {
    JSONObject objetoJSON = new JSONObject(output);
    OAuthToken = objetoJSON.getJSONObject("entry").getString("id");
  } else {
    log4j
        .debug("The response is empty [Code " + response.getStatusLine().getStatusCode() + "]");
  }

} else {
  log4j.debug("Error retrieving token: " + response.getStatusLine().getStatusCode() + " => "
      + response.getStatusLine().getReasonPhrase());
}
clientToken.getConnectionManager().shutdown();
OAuthToken = Base64.getEncoder().encodeToString(OAuthToken.getBytes());

return OAuthToken;
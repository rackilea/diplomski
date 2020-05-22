void authorize() {
try {

    authURL = "https://accounts.spotify.com/api/token";
    String idSecret = clientID + ":" + secretID;
    String idSecretEncoded = new String(Base64.encodeBase64(idSecret.getBytes()));

    HttpClient client = HttpClientBuilder.create().build();
    HttpPost post = new HttpPost(authURL);

    post.setHeader("User-Agent", USER_AGENT);
    post.setHeader("Content-Type", "application/x-www-form-urlencoded");
    post.setHeader("Authorization", "Basic " + idSecretEncoded);

    List<NameValuePair> urlParameters = new ArrayList<>();
    urlParameters.add(new BasicNameValuePair("grant_type", "client_credentials"));

    post.setEntity(new UrlEncodedFormEntity(urlParameters));

    HttpResponse response = client.execute(post);
    System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

    BufferedReader rd = new BufferedReader(
            new InputStreamReader(response.getEntity().getContent()));

    StringBuffer result = new StringBuffer();
    String line = "";
    while ((line = rd.readLine()) != null) {
        result.append(line);
    }
} catch (Exception e) {
    e.printStackTrace();
}
final HttpUriRequest request = RequestBuilder.get()
        .setUri("https://id.herokuapp.com/oauth/token")
        .setHeader("Content-Type", "application/x-www-form-urlencoded")
        .setHeader("Accept", "application/json")
        .setHeader("Authorization", "Basic AUTH_VALUE")
        .addParameter("username", "_USERNAME")
        .addParameter("password", "_PASSWORD")
        .addParameter("grant_type", "password")
        .addParameter("scope", "read write")
        .addParameter("client_secret", "_SECRET")
        .addParameter("client_id", "_CLIENT_ID")
        .build();

final HttpClient client = HttpClientBuilder.create().build();
final HttpResponse response = client.execute(request);
final HttpEntity entity = response.getEntity();

System.out.println(EntityUtils.toString(entity)); // or whatever processing you need
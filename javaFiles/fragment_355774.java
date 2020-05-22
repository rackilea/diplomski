OAuthClientRequest request = OAuthClientRequest
    .tokenLocation("https://bitbucket.org/site/oauth2/access_token")
    .setGrantType(GrantType.PASSWORD)
    .setUsername("someUsernameEnteredByEndUser")
    .setPassword("somePasswordEnteredByEndUser")
    .buildBodyMessage();
String key = "yourConsumerKey";
String secret = "yourConsumerSecret";
byte[] unencodedConsumerAuth = (key + ":" + secret).getBytes(StandardCharsets.UTF_8);
byte[] encodedConsumerAuth = Base64.getEncoder().encode(unencodedConsumerAuth);
request.setHeader("Authorization", "Basic " + new String(encodedConsumerAuth, StandardCharsets.UTF_8));
OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
OAuthResourceResponse response = oAuthClient.resource(request, OAuth.HttpMethod.POST, OAuthResourceResponse.class);
System.out.println("response body: " + response.getBody());
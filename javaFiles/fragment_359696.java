Token accessToken = new Token('your-expired-token-key', 'your-expired-token-secret')
println ".......................... Expired Token ........................\n $accessToken"

OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.login.yahoo.com/oauth/v2/get_token");
request.addOAuthParameter('oauth_session_handle', 'your-yahoo-session-handle') // you need to fetch it from the parameters when get your access token.
service.signRequest(accessToken, request);
Response response = request.send();
accessToken = YahooApi.class.newInstance().getAccessTokenExtractor().extract(response.getBody())

println ".......................... Refreshed Token ........................\n $accessToken"
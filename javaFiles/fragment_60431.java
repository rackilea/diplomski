OAuthConfig authConfig = new OAuthConfig("CONSUMER_KEY", "CONSUMER_SECRET", null, SignatureType.Header, null, null);
    Token token = new Token("TOKEN_ID", "TOKEN_SECRET");
    OAuth10aServiceImpl auth10aServiceImpl = new OAuth10aServiceImpl(new NetSuiteApi(), authConfig);
    OAuthRequest request = new OAuthRequest(Verb.GET, "RESTLET_URL");
    request.setRealm("NS_ACCOUNT_ID");
    auth10aServiceImpl.signRequest(token, request);
    Response response = request.send();
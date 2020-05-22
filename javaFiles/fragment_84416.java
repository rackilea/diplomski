//...
    //Connection objects
    DefaultHttpClient httpClient = new DefaultHttpClient(ccm, params);
    HttpPost httpPost = null;

    //Cookie stuff
    HttpContext httpContext = State.getHttpContext();
    httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.RFC_2109);
    //....
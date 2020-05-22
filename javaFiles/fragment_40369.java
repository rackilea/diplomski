ClientConfiguration config = WebClient.getConfig(proxy);
    HTTPConduit conduit = (HTTPConduit) config.getConduit();
    AuthorizationPolicy authorizationPolicy = new AuthorizationPolicy();
    authorizationPolicy.setUserName(USERNAME);                     
    authorizationPolicy.setPassword(PASSWORD);                   
    conduit.setAuthorization(authorizationPolicy);
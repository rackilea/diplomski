private GoogleCredential[] credentials;

@PostConstruct
private void createGoogleCredential() throws Exception {
    jsonFactory = JacksonFactory.getDefaultInstance();
    httpTransport = GoogleNetHttpTransport.newTrustedTransport();

    String[] refreshTokens = commaDelimitedListToStringArray(refreshTokensProp);
    numOfUsers = refreshTokens.length;

    credentials = new GoogleCredential[numOfUsers];
    for (int i=0; i<numOfUsers; i++) {
        GoogleCredential credential = new GoogleCredential.Builder()
                                        .setTransport(httpTransport)
                                        .setJsonFactory(jsonFactory)
                                        .setClientSecrets(clientId, clientSecret)
                                        .build();

        credential.setRefreshToken(refreshTokens[i]);

        credentials[i] = credential;
    }

    scriptIds = commaDelimitedListToStringArray(scriptsIdsProp);
}
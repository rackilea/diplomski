JsonFactory jsonFactory = new GsonFactory();
HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
GoogleCredential credentials = GoogleCredential.fromStream(getClass().getResourceAsStream("resources/sericeaccountinfo.json"), 
  restMethods.getHttpTransport(), 
                 jsonFactory)
                .createScoped(config.getScopes());
String emailAddress = "YOUR-SERVICE-ACCOUNT-NAME@developer.gserviceaccount.com";
JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
GoogleCredential credential = new GoogleCredential.Builder()
    .setTransport(httpTransport)
    .setJsonFactory(JSON_FACTORY)
    .setServiceAccountId(emailAddress)
    .setServiceAccountPrivateKeyFromP12File(new File("MyProject.p12"))
    .setServiceAccountScopes(Collections.singleton(StorageScopes.DEVSTORAGE_FULL_CONTROL))
    .build();
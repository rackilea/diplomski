public static Drive getDriveService2() {
    HttpTransport httpTransport = new NetHttpTransport();
    GsonFactory jsonFactory = new GsonFactory();
    GoogleCredential credential;
    Drive service = null;
    List<String> scopes = Arrays.asList(DriveScopes.DRIVE);
    try {
        credential = new GoogleCredential.Builder()
                .setTransport(httpTransport)
                .setJsonFactory(jsonFactory)
                .setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
                .setServiceAccountScopes(scopes)
                .setServiceAccountPrivateKeyFromP12File(
                        new java.io.File(SERVICE_ACCOUNT_PKCS12_FILE_PATH))
                .build();
        service = new Drive.Builder(httpTransport, jsonFactory, null).setApplicationName("MyAppName")
                .setHttpRequestInitializer(credential).build();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return service;
}
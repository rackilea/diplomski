GoogleCredential credential = new GoogleCredential.Builder()
   .setTransport(httpTransport)
   .setJsonFactory(jsonFactory)
   .setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
   .setServiceAccountScopes(DriveScopes.DRIVE)
   .setServiceAccountPrivateKeyFromP12File(
       new java.io.File(SERVICE_ACCOUNT_PKCS12_FILE_PATH))
   .build();
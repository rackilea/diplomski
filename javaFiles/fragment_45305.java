GoogleCredential credential = new GoogleCredential.Builder()
.setTransport(httpTransport)
.setJsonFactory(JSON_FACTORY)
.setServiceAccountId(emailAddress)
.setServiceAccountPrivateKeyFromP12File(new File("MyProject.p12"))
.setServiceAccountScopes(Collections.singleton(SQLAdminScopes.SQLSERVICE_ADMIN))
.setServiceAccountUser("user@example.com")
.build();
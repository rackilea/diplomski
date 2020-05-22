GoogleCredential credential = new GoogleCredential.Builder()
                    .setTransport(httpTransport)
                    .setJsonFactory(jsonFactory)
                    .setServiceAccountId("xxxxxx@developer.gserviceaccount.com")
                    .setServiceAccountScopes(Arrays.asList(DirectoryScopes.ADMIN_DIRECTORY_GROUP, DirectoryScopes.ADMIN_DIRECTORY_USER, DirectoryScopes.ADMIN_DIRECTORY_ORGUNIT))
                    .setServiceAccountUser(emailAccount)
                    .setServiceAccountPrivateKey(pk) //<----THIS
                    .build();
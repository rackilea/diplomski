GoogleCredentials credentials = GoogleCredentials.fromStream(
    new FileInputStream(PATH_TO_JSON_KEY)));
Publisher pub = Publisher
    .defaultBuilder(topicName)
    .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
    .build();
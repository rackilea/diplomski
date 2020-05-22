String SERVICE_ACCOUNT_JSON_PATH = "/path/to/service_account_credentials.json";

Storage storage =
    StorageOptions.newBuilder()
        .setCredentials(
            ServiceAccountCredentials.fromStream(
                new FileInputStream(SERVICE_ACCOUNT_JSON_PATH)))
        .build()
        .getService();
Bucket b = storage.get("mybucketname");
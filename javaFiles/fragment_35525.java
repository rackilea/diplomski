// fetch signature details from google
HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
GoogleCredential credential = new GoogleCredential.Builder()
    .setTransport(httpTransport)
    .setJsonFactory(jsonFactory)
    .setServiceAccountId(ACCOUNT_ID)
    .setServiceAccountScopes(Collections.singleton("https://www.googleapis.com/auth/androidpublisher"))
    .setServiceAccountPrivateKeyFromP12File(new File("key.p12"))
    .build();

AndroidPublisher pub = new AndroidPublisher.Builder(httpTransport, jsonFactory, credential)
    .setApplicationName(APPLICATION_NAME)
    .build();
AndroidPublisher.Purchases.Get get = pub.purchases().get(
    APPLICATION_NAME,
    PRODUCT_ID,
    token);
SubscriptionPurchase subscription = get.execute();
System.out.println(subscription.toPrettyString());
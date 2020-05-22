HttpHost proxy = new HttpHost("xx.xx.xx.xx", 80);

HttpTransportFactory transportFactory = () -> new ApacheHttpTransport.Builder()
                .setProxy(proxy)
                .build();

CredentialsProvider credentialsProvider = () -> GoogleCredentials.getApplicationDefault(transportFactory);

LanguageServiceSettings serviceSettings = LanguageServiceSettings.newBuilder()
                .setCredentialsProvider(credentialsProvider)
                .build();

LanguageServiceClient languageServiceClient = LanguageServiceClient.create(serviceSettings);
HttpClientBuilder clientBuilder = HttpClientBuilder.create();


  CredentialsProvider credsProvider = new BasicCredentialsProvider();

  credsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(USERNAME, PASSWORD));

  clientBuilder.useSystemProperties();

  clientBuilder.setProxy(new HttpHost(HOST, PORT));
            clientBuilder.setDefaultCredentialsProvider(credsProvider);
clientBuilder.setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy());


 Lookup<AuthSchemeProvider> authProviders = RegistryBuilder.<AuthSchemeProvider>create()
                    .register(AuthSchemes.BASIC, new BasicSchemeFactory())
                    .build();
            clientBuilder.setDefaultAuthSchemeRegistry(authProviders);


    Unirest.setClient(clientBuilder.build());
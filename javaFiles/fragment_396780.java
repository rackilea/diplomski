Registry<AuthSchemeProvider> r = RegistryBuilder.<AuthSchemeProvider>create()
        .register(AuthSchemes.BASIC, new BasicSchemeFactory())
        .register(AuthSchemes.DIGEST, new DigestSchemeFactory())
        .build();
CloseableHttpClient client = HttpClients.custom()
        .setDefaultAuthSchemeRegistry(r)
        .build();
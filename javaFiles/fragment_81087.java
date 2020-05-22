Lookup<AuthSchemeProvider> authSchemeRegistry = RegistryBuilder.<AuthSchemeProvider>create()
            .register(AuthSchemes.BASIC, new BasicSchemeFactory(Consts.UTF_8))
            .register(AuthSchemes.DIGEST, new DigestSchemeFactory(Consts.UTF_8))
            .register(AuthSchemes.NTLM, new NTLMSchemeFactory())
            .register(AuthSchemes.SPNEGO, new SPNegoSchemeFactory())
            .register(AuthSchemes.KERBEROS, new KerberosSchemeFactory())
            .build();
CloseableHttpClient httpclient = HttpClients.custom()
        .setDefaultAuthSchemeRegistry(authSchemeRegistry)
        .build();
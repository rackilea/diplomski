RequestConfig config = RequestConfig.custom()
        .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.KERBEROS, AuthSchemes.SPNEGO))
        .build();
CloseableHttpClient client = HttpClients.custom()
        .setDefaultRequestConfig(config)
        .build();
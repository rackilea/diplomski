SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(null,
        new TrustSelfSignedStrategy()).build();

// Allow TLSv1 protocol only, use NoopHostnameVerifier to trust self-singed cert
SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,
        new String[] { "TLSv1" }, null, new NoopHostnameVerifier());

//do not set connection manager
httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

HttpPost httpPost = new HttpPost(url);

RequestConfig defaultRequestConfig = RequestConfig
        .custom()
        .setCookieSpec(CookieSpecs.DEFAULT)
        .setExpectContinueEnabled(true)
        .setTargetPreferredAuthSchemes(
                Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
        .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig)
        .setSocketTimeout(TIME_OUT).setConnectTimeout(TIME_OUT)
        .setConnectionRequestTimeout(TIME_OUT).build();
httpPost.setConfig(requestConfig);

httpPost.setHeader("Content-type", "application/json");
StringEntity mEntity = new StringEntity(arg, "UTF-8");
mEntity.setContentType("application/json;charset=UTF-8");
mEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
        "application/json;charset=UTF-8"));
httpPost.setEntity(mEntity);

response = httpclient.execute(httpPost);
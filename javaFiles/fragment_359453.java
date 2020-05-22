@Value("${com.myapplication.userAgent}")
 private String userAgent;
private HttpClient httpClient= HttpClientBuilder.create()
    .setDefaultCookieStore(new BasicCookieStore())
    .setUserAgent(userAgent)
    .setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build())
    .setDefaultHeaders(Arrays.asList(
            new BasicHeader("Accept-Encoding", "gzip"),
            new BasicHeader("Connection", "keep-alive"))
    )
    .build();
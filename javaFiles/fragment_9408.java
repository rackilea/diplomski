public CloseableHttpClient build() {
    ... snip ...
    HttpClientConnectionManager connManagerCopy = this.connManager;
    if (connManagerCopy == null) {
        ... snip ...
        @SuppressWarnings("resource")
        final PoolingHttpClientConnectionManager poolingmgr = new PoolingHttpClientConnectionManager(
                RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslSocketFactoryCopy)
                    .build(),
                null,
                null,
                null,
                connTimeToLive,
                connTimeToLiveTimeUnit != null ? connTimeToLiveTimeUnit : TimeUnit.MILLISECONDS);
        ... snip ...
        if (maxConnTotal > 0) {
            poolingmgr.setMaxTotal(maxConnTotal);
        }
        if (maxConnPerRoute > 0) {
            poolingmgr.setDefaultMaxPerRoute(maxConnPerRoute);
        }
        connManagerCopy = poolingmgr;
    }
    ... snip ...
    return new InternalHttpClient(... snip ...);
}
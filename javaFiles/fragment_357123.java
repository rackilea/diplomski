public static OkClient createClient(int readTimeout, TimeUnit readTimeoutUnit, int connectTimeout, TimeUnit connectTimeoutUnit)
{
    final OkHttpClient okHttpClient = new OkHttpClient();
    okHttpClient.setReadTimeout(readTimeout, readTimeoutUnit);
    okHttpClient.setConnectTimeout(connectTimeout, connectTimeoutUnit);

    try {
        URL url = new URL(ApiIntentService.getHostAddress());
        SSLSocketFactory NoSSLv3Factory = new NoSSLv3SocketFactory(url);
        okHttpClient.setSslSocketFactory(NoSSLv3Factory);
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return new OkClient(okHttpClient);

}
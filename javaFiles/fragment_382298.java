...
...
httpclient.setHttpRequestRetryHandler(myRetryHandler);

uri = AppInit.fieldProxyURI + ";jsessionid=" + sessionInfo.getAttribute(GatewayConstants.PROXYSESSIONID);
HttpPost httppost = new HttpPost(uri);
nvps =(List<NameValuePair>) sessionInfo.getAttribute(GatewayConstants.PROXY_QUERY_PARAMS);
httppost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
ProxyPoster thread = new ProxyPoster(httpclient,httppost,sessionInfo,localContext);
thread.start();
thread.join();

} finally {
// leave the connection resource open
}

static class ProxyPoster extends Thread {
    //fields here..

    // constructor here...

@Override
public void run() {
    try {
        HttpResponse response = httpClient.execute(httppost, context);
        // proccess response
    } catch (Exception e) {
        httppost.abort();
    }
}
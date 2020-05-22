IOReactorConfig ioReactorConfig = IOReactorConfig.custom().setIoThreadCount(10).build();
ConnectingIOReactor ioReactor = new DefaultConnectingIOReactor(ioReactorConfig);
PoolingNHttpClientConnectionManager cm = new PoolingNHttpClientConnectionManager(ioReactor);
cm.setMaxTotal(100);
cm.setDefaultMaxPerRoute(10);

RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(30000)
                .setSocketTimeout(30000).build();

CloseableHttpAsyncClient httpclient = HttpAsyncClients.custom()
                .setConnectionManager(cm)
                .setConnectionManagerShared(false)
                .setDefaultRequestConfig(requestConfig)
                .build();
httpclient.start();

HttpPatch httpReq = new HttpPatch(url);
StringEntity entity = new StringEntity(json);
httpReq.setEntity(entity);

Future<HttpResponse> future = httpclient.execute(httpReq, context, null);
HttpResponse httpResponse = future.get();
HttpEntity responseEntity = httpResponse.getEntity();
String responseText = responseEntity != null ? EntityUtils.toString(responseEntity) : null;
SocketConfig socketConfig = SocketConfig.custom().setSoKeepAlive(true).setSoTimeout(3600000).build(); //We need to set socket keep alive
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(3600000).build();
        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).
                                           setDefaultSocketConfig(socketConfig).build();
HttpPost post = new HttpPost(url.toString());
HttpResponse response = httpClient.execute(post);
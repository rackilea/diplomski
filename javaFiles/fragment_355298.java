RequestConfig defaultRequestConfig = RequestConfig.custom()
        .setConnectTimeout(timeout)
        .setSocketTimeout(timeout)
        .setConnectionRequestTimeout(managerTimeout)
        .build();

CloseableHttpClient httpClient = HttpClients.custom()
        .setConnectionManager(connectionManager)
        .setDefaultRequestConfig(defaultRequestConfig)
        .build();

RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig)
        .setConnectTimeout(timeout * 2)
        .setSocketTimeout(timeout * 2)
        .setConnectionRequestTimeout(managerTimeout * 2)
        .build();

HttpGet get = new HttpGet();
get.setConfig(requestConfig);
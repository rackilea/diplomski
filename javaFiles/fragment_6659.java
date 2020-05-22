@Bean("apacheRequestFactory")
    public ClientHttpRequestFactory createRequestFactory() {

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();

        // maximum connections in the pool
        connectionManager.setMaxTotal(this.systemPropertyBean.getPushConsumerThreadCnt());

        // maximum concurrent connection to the hosts is equal to the our push thread count.
        connectionManager.setDefaultMaxPerRoute(this.systemPropertyBean.getPushConsumerThreadCnt());

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(this.systemPropertyBean.getPushTimeoutMillis())// 3 sn
                .setConnectionRequestTimeout(this.systemPropertyBean.getPushTimeoutMillis())
                .setSocketTimeout(this.systemPropertyBean.getPushTimeoutMillis()).build(); // read timeout

/*      the Connection Timeout (http.connection.timeout) – the time to establish the connection with the remote host
        the Socket Timeout (http.socket.timeout) – the time waiting for data – after the connection was established; maximum time of inactivity between two data packets
        the Connection Manager Timeout (http.connection-manager.timeout) – the time to wait for a connection from the connection manager/pool
*/        
        CloseableHttpClient httpClient = HttpClientBuilder.create().setConnectionManager(connectionManager).setDefaultRequestConfig(config).build();
        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }

    @Bean
    public RestTemplate restTemplate() {
// I was using SimpleClientHttpRequestFactory before.
        RestTemplate restTemplate = new RestTemplate(createRequestFactory());
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        return restTemplate;
    }
package com.acme.config;

import org.hibernate.search.elasticsearch.client.spi.ElasticsearchHttpClientConfigurer;

public class MyHttpConfigurer implements ElasticsearchHttpClientConfigurer {
   private static final int KEEP_ALIVE_MS = 20 * 60 * 1000; // 20 minutes
    @Override
    public void configure(HttpAsyncClientBuilder builder, Properties properties) {
        builder.setKeepAliveStrategy( (response, context) -> KEEP_ALIVE_MS );
    }
}
HttpClient httpClient = HttpClient
    .create((HttpClientOptions.Builder builder) -> builder
    .host(endpointUrl.getHost())
    .port(endpointUrl.getPort())
    .poolResources(PoolResources.fixed(connectionPoolName, maxConnections, timeoutPool))
    .afterChannelInit(channel -> {
        channel.pipeline()
                // The write and read timeouts are serving as generic socket idle state handlers.
                .addFirst("write_timeout", new WriteTimeoutHandler(timeoutIdle, TimeUnit.MILLISECONDS))
                .addFirst("read_timeout", new ReadTimeoutHandler(timeoutIdle, TimeUnit.MILLISECONDS));
    })
    .build());
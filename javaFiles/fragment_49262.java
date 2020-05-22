@Bean
public WebClient.Builder webClientBuilder() {
    String connectionProviderName = "myConnectionProvider";
    int maxConnections = 100;
    int acquireTimeout = 1000;
    HttpClient httpClient = HttpClient.create(ConnectionProvider
            .fixed(connectionProviderName, maxConnections, acquireTimeout));
    return WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(httpClient));
}
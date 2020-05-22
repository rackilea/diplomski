@Bean
public CloseableHttpClient httpClient() throws Throwable {
    return HttpClients.custom()
           .......ssl context or sslsocketfactory settging.
           .build();
}
@Override
public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

    final String id = exchange.getRequest()
                                 .getHeaders()
                                 .getFirst("reference");

    return returnsMonoServerMappingService.getServerMapping(id)
                     .doOnSuccess(serverMapping -> {                
                         exchange.getAttributes()
                             .put(GATEWAY_REQUEST_URL_ATTR, URI.create("https://" + server.getHost()
        }).then(chain.filter(exchange));
}
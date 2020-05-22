@Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String traceId = UUID.randomUUID().toString();
        long startTime = System.currentTimeMillis();
        String path = exchange.getRequest().getURI().getPath();
        System.out.printf("Request[%s] started, trace_id[%s]", path, traceId);

        return chain.filter(exchange)
                .doAfterSuccessOrError((r, t) -> {
                    System.out.printf("Request[%s], completed, status_code[%s], time[%d], trace_id[%s]", path,
                            exchange.getResponse().getStatusCode(), System.currentTimeMillis() - startTime, traceId);
                })
                .subscriberContext(Context.of(String.class, traceId));
    }
Mono<List<String>> response = Flux.fromIterable(queue)
                                  .flatMap(this::callHttp)
                                  .collectList();

private Mono<String> callHttp(String req)
{
    return webClient
            .post()
            .syncBody(req)
            .retrieve()
            .bodyToMono(String.class)
            .retry(3); // retries failed requests at most 3 times
}
public Mono<List<Result>> findByType(Request request) {
        return find(request)
                .expand(response -> {
                    int nextFrom = response.getFrom() + response.getSize();
                    if (nextFrom >= response.getTotalResults()) {
                        return Mono.empty();
                    }
                    return find(new Request(request.getType(), response.getFrom() + response.getSize()));
                })
                 .flatMap(response -> Flux.fromIterable(response.getResults()))
                 .collectList();;
    }

    private Mono<Response> find(Request request) {
        return webClient
                .post()
                .uri("/search")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .syncBody(request)
                .retrieve()
                .bodyToMono(Response.class);
    }
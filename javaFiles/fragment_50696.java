public Mono<List<APrice>> getAPrice() {

    return Flux.fromIterable(getActiveMonths().entrySet())
        .flatMap(entry -> getContractPrice(entry.getKey(), entry.getValue()))
        .flatMapIterable(aPrices -> aPrices).collectList();
}
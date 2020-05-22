myflux.flatMap(v -> {
    try {
        return Flux.just(converter.convertHistoricalCSVToStockQuotation(stock));
    } catch (IllegalArgumentException ex) {
        return Flux.empty();
    }
});
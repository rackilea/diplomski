long sentAt = System.nanoTime();

return webClient.post()
    .uri("/orders")
    .body(BodyInserters.fromObject(order))
    .retrieve()
    .bodyToMono(ORDER_PARAMETERIZED_TYPE)
    .doFinally(r -> histogram.recordValue(System.nanoTime() - sentAt))
    ;
Mono<String> m1 = Mono.just("A");
Mono<String> m2 = Mono.just("B");
Mono<String> m3 = Mono.empty().defaultIfEmpty("");

Mono<String> combined = Mono.when(m1, m2, m3).map(t -> {
    StringBuffer sb = new StringBuffer();
    sb.append(t.getT1());
    sb.append(t.getT2());
    sb.append(t.getT3());
    return sb.toString();
});
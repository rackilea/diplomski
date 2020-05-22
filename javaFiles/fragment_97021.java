Flux<Tuple2<T, Integer>> sourceFlux = ...; //assuming key/count represented as `Tuple2`
Flux<Tuple2<T, Integer>> aggregated = sourceFlux.compose(source -> {
    //having this state inside a compose means it will not be shared by multiple subscribers
    AtomicReference<T> last = new AtomicReference<>(null);

    return source
      //use "last seen" state so split into windows, much like a `groupBy` but with earlier closing
      .windowUntil(i -> !i.getT1().equals(last.getAndSet(i.getT1())), true)
      //reduce each window
      .flatMap(window -> window.reduce((i1, i2) -> Tuples.of(i1.getT1(), i1.getT2() + i2.getT2()))
});
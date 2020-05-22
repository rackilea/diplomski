ConnectableFlux<Double> secureRandomFlux = Flux.using(
    () -> new SecureRandom(),
    sr -> Flux.interval(10, TimeUnit.MILLISECONDS)
          .map(v -> sr.nextDouble())
          .onBackpressureDrop()
    sr -> { }
).publish();
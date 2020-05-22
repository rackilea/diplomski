@PostMapping
public Mono<String> getPlanetNames(@RequestBody Mono<Delay> delayBody) {
  return delayBody.flatMap(p -> {
    return Mono.just(getRandomPlanetName())
        .delayElement(Duration.ofMillis(p.getDelayTime()));
  });
}

private String getRandomPlanetName() {
  Random rand = new Random();
  List<String> list = Arrays.asList("Mercury", "Neptune");
  return list.get(rand.nextInt(list.size()));
}
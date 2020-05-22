@Test
public void groupAndFlatmapTest() {
    val groupCount = 257;
    val groupSize = 513;
    val list = rangeClosed(1, groupSize * groupCount).boxed().collect(Collectors.toList());
    val source = Flux.fromIterable(list)
            .groupBy(i -> i % groupCount)
            .flatMap(Flux::collectList);
    StepVerifier.create(source).expectNextCount(groupCount).expectComplete().verify();
}
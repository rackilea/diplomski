Collections.sort(localDateTimes);
final double average = IntStream.range(0, localDateTimes.size() - 1)
    .mapToLong(l ->
        Duration.between(
            localDateTimes.get(l),
            localDateTimes.get(l+1))
        .toNanos())
    .average().orElse(0.0);
assertThat(Duration.ofNanos((long) average)).isEqualTo(Duration.parse("PT2H31M"));
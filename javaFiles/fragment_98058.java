Stream<Character> testStream = Stream.of('a', 'b', 'c');

String result = testStream.collect(Collector.of(
    StringBuilder::new,
    StringBuilder::append,
    StringBuilder::append,
    StringBuilder::toString));
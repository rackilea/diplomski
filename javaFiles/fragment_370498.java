Stream.of("A1", "A2").flatMap(t -> {
    Stream.Builder<String> subStream = Stream.builder();
    subStream.add(t);
    for (int i = 1; i < 3; i++) {
        subStream.add("B" + i);
    }
    return subStream.build();
}).forEach(System.out::print);
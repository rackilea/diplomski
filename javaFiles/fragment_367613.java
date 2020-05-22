static String removePunctuation(String x) { return x; }
static String stem(String x) { return x; }

// ...

final Map<String, Long> yeah = Seq.of("a", "b", "c")
        .map(Test::removePunctuation)
        .map(Test::stem)
        .groupBy(Function.identity(), Collectors.counting());
final Map<String, String> example = Map.of(
        "1", "A",
        "2", "B",
        "3", "A",
        "4", "B"
        );

groupByValue(example).forEach((k, v) -> System.out.printf("%s->%s%n", k, v));
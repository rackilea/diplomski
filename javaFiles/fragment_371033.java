BIGMAP.values()
        .stream()
        .flatMap(m -> m.keySet().stream())
        .distinct()
        .sorted()
        .map(k -> k
                + " "
                + BIGMAP.entrySet()
                        .stream()
                        .sorted(comparing(Entry::getKey))
                        .map(e -> e.getValue()
                                   .getOrDefault(k, Collections.emptyList())
                                   .stream()
                                   .map(String::valueOf)
                                   .collect(joining(":")))
                        .collect(joining(", ")))
        .forEachOrdered(System.out::println);
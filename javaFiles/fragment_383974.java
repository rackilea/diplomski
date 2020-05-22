Files.lines(Paths.get(path))
      .flatMap(delimeter::splitAsStream)
      .map(String::toLowerCase)
      .filter(s -> s.indexOf(symbol) >= 0)
      .distinct()
      .map(s -> new SimpleEntry<>(s, s.chars().filter(c -> c == symbol).count()))
      .sorted(Map.Entry.<String,Long>comparingByValue(Comparator.reverseOrder())
                    .thenComparing(Map.Entry::getKey))
      .collect(toMap(SimpleEntry::getKey, e -> e.getValue().intValue(), (l, r) -> l, LinkedHashMap::new));
private static void doMap(List<Foo> foos) {
    foos.stream()
        .filter(foo -> !foo.getBars()
                           .isEmpty())
        .map(foo -> new SimpleEntry<>(foo.getId(), foo.getBars()
                                                      .stream()
                                                      .map(bar -> new SimpleEntry<>(bar.getId(), bar.getValues()))
                                                      .filter(entry -> !entry.getValue()
                                                                             .isEmpty())
                                                      .collect(entriesToMapCollector())))
        .filter(entry -> !entry.getValue().isEmpty())
        .collect(entriesToMapCollector());
}

private static <K, V> Collector<Entry<K, V>, ?, Map<K, V>> entriesToMapCollector() {
    return Collectors.toMap(Entry::getKey, Entry::getValue);
}
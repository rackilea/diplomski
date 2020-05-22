public Map<Country, Long> count(Path path) throws IOException {
    return Files.lines(path)
            .flatMap(line -> getRelevantCells(line))
            .map(Country::getByCode)
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
}

private Stream<String> getRelevantCells(String line) {
    String[] cells = line.split(",");
    return Stream.of(cells[0], cells[8]);
}
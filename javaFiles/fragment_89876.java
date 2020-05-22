List<String> minDup = a1.stream()
    .collect(Collectors.groupingBy(s -> s.substring(0, 10)))
    .values().stream()
    .filter(list -> list.size() > 1)
    .map(Collections::min)
    .collect(Collectors.toList());
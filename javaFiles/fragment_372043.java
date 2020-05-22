private List<Integer> testStreamMap(Map<Integer, Long> mapGroup) {
    if(mapGroup.isEmpty())
        return Collections.emptyList();
    long max = mapGroup.values().stream().max(Comparator.naturalOrder()).get();
    return mapGroup.entrySet().stream()
        .filter(e -> e.getValue() == max)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
}
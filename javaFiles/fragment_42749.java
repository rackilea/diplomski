static List<String> getTopN(Map<String, Double> map, int n) {

    TreeSet<Map.Entry<String, Double>> topN = new TreeSet<>(
        Map.Entry.<String, Double>comparingByValue()
            .reversed()                         // by value descending, then by key
            .thenComparing(Map.Entry::getKey)); // to allow entries with repeated values

    map.entrySet().forEach(e -> {
      topN.add(e);
      if (topN.size() > n) topN.pollLast();
    });

    return topN.stream()
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
}
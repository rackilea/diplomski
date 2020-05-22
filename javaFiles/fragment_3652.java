List<Map.Entry<String, Integer>> result = map.entrySet().stream()
    .sorted(Map.Entry.<String, Integer>comparingByValue()
            .reversed()
            .thenComparing(Map.Entry::getKey))
    .limit(2)
    .collect(toList());
Map<String, Integer> sortedMap = Points.entrySet().stream()
        .sorted(Collections
                .reverseOrder(
                        Map.Entry.<String, Integer>comparingByValue())
                .thenComparing(Map.Entry.comparingByKey()))
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new));
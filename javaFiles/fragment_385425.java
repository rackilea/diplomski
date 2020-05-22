Comparator<Map.Entry<String, Integer>> valueOrMinKey
    = Map.Entry.<String, Integer>comparingByValue()
         .thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder()));

Map<Integer, String> attrIdMaxValueMap =
    attrIdAttrValueCountMap.entrySet().stream()
        .filter(e -> !e.getValue().isEmpty())
        .collect(Collectors.toMap(Map.Entry::getKey,
            e -> e.getValue().entrySet().stream().max(valueOrMinKey).get().getKey()));
Map<Integer, String> attrIdMaxValueMap =
    attrIdAttrValueCountMap.entrySet().stream()
        .filter(e -> !e.getValue().isEmpty())
        .collect(Collectors.toMap(Map.Entry::getKey,
            e -> e.getValue().entrySet().stream()
                .max(Map.Entry.<String, Integer>comparingByValue()
                       .thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder())))
                .get().getKey()));
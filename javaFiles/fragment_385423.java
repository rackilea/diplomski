Map<Integer, String> attrIdMaxValueMap =
    attrIdAttrValueCountMap.entrySet().stream()
        .filter(e -> !e.getValue().isEmpty())
        .collect(Collectors.toMap(Map.Entry::getKey,
            e -> e.getValue().entrySet().stream()
                .min(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey())).get().getKey()));
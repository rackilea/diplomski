mapOfMap.entrySet().stream()
        .collect(HashMap::new,
                (hashMap, topMap) -> {
                    TreeMap<TopLevelMapKey, InnerMapValue> value = topMap.getValue()
                            .entrySet().stream()
                            .collect(TreeMap::new,
                                    (treeMap, innerMap) -> treeMap.put(innerMap.getKey().getUpdatedKey(), innerMap.getValue()),
                                    TreeMap::putAll);
                    hashMap.put(topMap.getKey(), value);
                },
                HashMap::putAll);
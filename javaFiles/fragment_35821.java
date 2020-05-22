// Search by single key, say key1
        List<CompositeKey> list = key1Index.get(key1);
        List<Object> result = getResult(list, dataMap);

        // Search by two keys, say key 1 and key 2
        List<CompositeKey> key1IndexResult = key1Index.get(key1);
        List<CompositeKey> key1Key2List = key1IndexResult.stream()
            .filter(ck -> ck.getKey2().equals(key2))
            .collect(Collectors.toList());

        List<Object> key1Key2Result = getResult(key1Key2List, dataMap);

        // Search by all 3 keys
        CompositeKey allKeys = new CompositeKey(key1, key2, key3);
        List<Object> allKeysResult = getResult(Collections.singletonList(allKeys), dataMap);
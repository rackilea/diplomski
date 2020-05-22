Map<String, Object> newMap = new HashMap<>();
    while (iterator.hasNext()) {
        Map.Entry<String, Object> entry = iterator.next();
        iterator.remove();
        newMap.put(...);  // Whatever logic to compose new key/value pair.
    }
    map.putAll(newMap);
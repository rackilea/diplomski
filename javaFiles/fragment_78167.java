// The result map
for (final String key: formulaMap.keySet()) {
    map.put(formulaMap.get(key), valueMap.get(key));

// Either return the new map, or do:
valueMap.clear();
valueMap.putAll(map);
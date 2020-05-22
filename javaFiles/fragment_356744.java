for (Entry<String, String> entry: hMap.entrySet()) {
    // Check if the current value is a key in the 2nd map
    if (!hMap2.containsKey(entry.getValue()) {

        // hMap2 doesn't have the key for this value. Add key-value in new map.
        hMap3.put(entry.getKey(), entry.getValue());
    }
}
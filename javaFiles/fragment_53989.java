if (map.get(key) == null) {
    V newValue = mappingFunction.apply(key);
    if (newValue != null) {
         map.put(key, newValue);
    }
}
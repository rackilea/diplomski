final String value = entry.getValue();
if (value instanceof String || value instanceof Number) {
    return Stream.of(new AbstractMap.SimpleEntry(entry.getKey(),
                                                value.toString()));
}
else if (value instanceof Map) {
    return flatten((Map<String, Object>) value);
}
// you may return null but you will at least log something
else {
     LOGGER.warn("field with key {} and value {} not mapped", entry.getKey(), value);
     return null;
}
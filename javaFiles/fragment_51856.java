static Map<String, Object> flatten(Map<?, ?> map) {
    return flatten("", map)
            .mapKeys(k -> k.substring(1))
            .toMap();
}

static EntryStream<String, Object> flatten(String key, Object value) {
    if (value instanceof Map) {
        return EntryStream.of((Map<?, ?>)value)
                .flatMapKeyValue((k, v) -> flatten(key + "." + k, v))
                .chain(EntryStream::of);
    } else {
        return EntryStream.of(key, value);
    }
}
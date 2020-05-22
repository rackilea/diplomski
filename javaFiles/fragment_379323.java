Set<String> keys = new HashSet<>(properties1.keySet());
// For intersection:
keys.retainAll(properties2.keySet());
// For union:
// keys.addAll(properties2.keySet());

for (String key : keys) { ... }
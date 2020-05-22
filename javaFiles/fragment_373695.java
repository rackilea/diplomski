public Map<String, String> split(CharSequence sequence) {
  Map<String, String> map = new LinkedHashMap<String, String>();
  for (String entry : outerSplitter.split(sequence)) {
    Iterator<String> entryFields = entrySplitter.splittingIterator(entry);

    checkArgument(entryFields.hasNext(), INVALID_ENTRY_MESSAGE, entry);
    String key = entryFields.next();
    checkArgument(!map.containsKey(key), "Duplicate key [%s] found.", key);

    checkArgument(entryFields.hasNext(), INVALID_ENTRY_MESSAGE, entry);
    String value = entryFields.next();
    map.put(key, value);

    checkArgument(!entryFields.hasNext(), INVALID_ENTRY_MESSAGE, entry);
  }
  return Collections.unmodifiableMap(map);
}
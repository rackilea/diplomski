public <T> Optional<T> get(int index, Class<T> type) {
  Object item = items.get(index);
  if (type.isInstance(item)) {
    return Optional.of(type.cast(item));
  }
  return Optional.empty();
}
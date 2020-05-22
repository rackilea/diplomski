List<String> flatten(List<?> objects) {
  return objects.stream()
    .filter(Objects::nonNull)
    .flatMap(v -> v instanceof String
      ? Stream.of((String) v)
      : flatten((List<?>) v).stream())
    .collect(Collectors.toList());
}
List<String> flat = objects.stream()
  .filter(Objects::nonNull)
  .flatMap(v -> {
    if (v instanceof String) {
      return Stream.of((String) v);
    }
    return ((List<String>) v).stream().filter(Objects::nonNull);
  })
  .collect(Collectors.toList());
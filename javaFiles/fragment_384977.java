return params.stream()
  .filter(p -> key.equals(p.getKey())
  .filter(p -> ! p.getValues().isEmpty())
  .map(p -> p.getValues().get(0))
  .findFirst()
  .orElse("");
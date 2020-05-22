ArrayList<NonReference> result = schedual.stream()
    .filter(NonReference.class::isInstance)
    .map(NonReference.class::cast)
    .collect(Collectors.toCollection(ArrayList::new));

return Collections.unmodifiableList(result);
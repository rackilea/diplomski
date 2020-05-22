List<Integer> flattened = 
  list
    .stream()
    .filter (Optional::isPresent)
    .map(Optional::get)
    .collect(Collectors.toList());
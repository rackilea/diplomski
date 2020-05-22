List<Integer> result = models.stream().flatMap(p -> {
    switch (p.getState()) {
    case 1:
        return Stream.of(p.getLeft());
    case 2:
        return Stream.of(p.getRight());
    case 3:
        return Stream.of(p.getLeft(), p.getRight());
    default:
        return Stream.of(p.getLeft());
        // you can also return Stream.empty() if appropriate
    }
}).collect(Collectors.toList());
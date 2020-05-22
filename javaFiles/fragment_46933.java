films.stream()
    .filter(Film.LENGTH.greaterThan(120))
    .sorted(Film.LENGTH.comparator().reversed())  // <--- Here
    .skip(100)
    .limit(50)
    .collect(Collectors.toList());
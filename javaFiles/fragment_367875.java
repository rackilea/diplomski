List<Pair<A, B>> ab = a.stream()
    .map(aa -> Pair.of(aa, b.stream()
        .filter(bb -> bb.getKey().equals(aa.getKey()))
        .findAny()
        .get()))   // will throw exception if missing
    .collect(Collectors.toList());
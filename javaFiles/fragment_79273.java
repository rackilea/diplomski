List<YourNewObjectType> result = objectList.stream()
    .flatMap(objA -> objectList.stream()
        .filter(objB -> !Objects.equals(objA, objB))
        .map(objB -> new Pair<>(objA,objB)))
    .distinct()
    .filter(pair -> condition)
    .map(pair -> new YourNewObjectType … )
    .collect(Collectors.toList());
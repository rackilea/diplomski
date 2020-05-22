List<YourNewObjectType> result = objectList.stream()
    .flatMap(objA -> objectList.stream().map(objB -> new Pair<>(objA,objB)))
    .distinct()
    .filter(pair -> condition)
    .map(pair -> new YourNewObjectType … )
    .collect(Collectors.toList());
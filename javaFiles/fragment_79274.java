List<YourNewObjectType> result = IntStream.range(0, objectList.size())
    .mapToObj(i -> IntStream.range(i/*+1*/, objectList.size())
        .mapToObj(j -> new Pair<>(objectList.get(i),objectList.get(j))))
    .flatMap(Function.identity())
    .filter(pair -> condition)
    .map(pair -> new YourNewObjectType … */)
    .collect(Collectors.toList());
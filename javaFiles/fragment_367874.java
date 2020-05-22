Map<KeyType, A> keyToA = a.stream()
    .collect(Collectors.toMap(A::getKey, Function.identity()));

List<Pair<A, B>> ab = b.stream()
    .map(bb -> Pair.of(keyToA.get(bb.getKey()), bb))
    .collect(Collectors.toList());
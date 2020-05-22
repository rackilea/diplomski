List<Pair<A, B>> list = ...;
List<Pair<A, List<B>>> result = list.stream()
        .collect(Collectors.groupingBy(Pair::getKey, LinkedHashMap::new, 
                Collectors.mapping(Pair::getValue, Collectors.toList())))
        .entrySet().stream()
        .map(e -> new Pair<>(e.getKey(), e.getValue()))
        .collect(Collectors.toList());
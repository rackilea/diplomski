List<Integer> dest = list
        .stream()
        .filter(map.entrySet()                            // filter with a predicate ...
                .stream()
                .filter(e -> e.getKey().get())            // .. where a condition is 'true'
                .map(Entry::getValue)                     // .. get Predicates
                .reduce(i -> true, (l, r) -> l.and(r)))   // .. reduce them using AND
        .collect(Collectors.toList());
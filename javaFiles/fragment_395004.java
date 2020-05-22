final List<L> list = map
        // get a Collection<List<L>>
        .values()
        // make a stream from the collection
        .stream()
        // turn each List<L> into a Stream<L> and merge these streams
        .flatMap(List::stream)
        // accumulate the result into a List
        .collect(Collectors.toList());
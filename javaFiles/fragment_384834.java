Supplier<Stream<NamedPredicate<Person>>> truthTable
    = predicates.stream() // start with plain predicates
        .<Supplier<Stream<NamedPredicate<Person>>>>map(
            // generate a supplier which creates a stream of 
            // true-predicate and false-predicate
            p -> () -> Stream.of(
                    new NamedPredicate<>(p, "T"),
                    new NamedPredicate<>(p.negate(), "F")))
        .reduce(
            // reduce each pair of suppliers to the single supplier
            // which produces a Cartesian product stream
            (s1, s2) -> () -> s1.get().flatMap(np1 -> s2.get()
                            .map(np2 -> new NamedPredicate<>(np1.and(np2), np1+" "+np2))))
        // no input predicates? Fine, produce empty stream then
        .orElse(Stream::empty);
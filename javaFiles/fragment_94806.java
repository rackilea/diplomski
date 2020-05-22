List<String> newList =
    listA.stream() // Stream<A>
         .flatMap(a->a.getB().stream()) // Stream<B>
         .flatMap(b->b.getC().stream()) // Stream<C>
         .flatMap(c->c.gtPeople().stream()) // Stream<String>
         .collect(Collectors.toList()); // List<String>
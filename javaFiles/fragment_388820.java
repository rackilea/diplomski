List<A> listA = ...;

List<C> listC = listA.stream()
    .flatMap(a -> a.refiners.stream()
        .map(b -> {
            C c = new C();
            c.domain = a.domain;
            c.name = b.name;
            c.signature = b.signature;
            return c;
        }))
    .collect(Collectors.toList());
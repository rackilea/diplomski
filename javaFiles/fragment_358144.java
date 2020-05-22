Optional.ofNullable(objectA)
    .map(a -> a.getObjectB())
    .map(b -> b.getObjectC())
    .map(c -> c.getObjectD())
    .map(d -> d.getObjectE())
    .map(e -> e.getName())
    .orElse("");
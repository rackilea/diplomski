Map<Boolean,Integer> counts = results.stream()
    .collect(Collectors.collectingAndThen(Collectors.groupingBy(r -> (int)r.getId(),
        Collector.of(() -> new Object() { int count = 0; boolean pass = true; },
            (o, r) -> { o.count++; o.pass &= r.getPassed(); },
            (x, y) -> { x.count += y.count; x.pass &= y.pass; return x; }
        )),
        m -> m.values().stream().collect(
            Collectors.partitioningBy(o -> o.pass, Collectors.summingInt(o -> o.count)))
    ));
Map<Boolean,Integer> counts = results.stream()
    .collect(Collectors.collectingAndThen(Collectors.groupingBy(r -> (int)r.getId(),
        Collector.of(() -> new Object() { int passed, failed; },
            (o, r) -> { if(r.getPassed()) o.passed++; else o.failed++; },
            (x, y) -> { x.passed += y.passed; x.failed += y.failed; return x; }
        )),
        m -> m.values().stream()
            .filter(o -> o.passed == 0 || o.failed == 0)
            .collect(Collectors.partitioningBy(o -> o.failed==0,
                Collectors.summingInt(o -> o.failed==0? o.passed: o.failed)))
    ));
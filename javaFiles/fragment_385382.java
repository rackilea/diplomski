int totalPassedCount = results.stream()
    .collect(Collectors.collectingAndThen(Collectors.groupingBy(r -> (int)r.getId(),
        Collector.of(() -> new Object() { int count = 0; boolean pass = true; },
            (o, r) -> { o.count++; o.pass &= r.getPassed(); },
            (x, y) -> { x.count += y.count; x.pass &= y.pass; return x; },
            o -> o.pass? o.count: 0
        )),
        (Map<Integer,Integer> x) -> x.values().stream().mapToInt(i -> i).sum()
    ));
System.out.println(totalPassedCount);
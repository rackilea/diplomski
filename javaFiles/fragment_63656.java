AtomicInteger i = new AtomicInteger();
String result = table.values()
        .stream()
        .sorted(...)
        .map(e -> i.incrementAndGet() + "_" + e)
        .collect(Collectors.joining());
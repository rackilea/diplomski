AtomicInteger position = new AtomicInteger(-1);

String firstNotHiddenItem = entries.stream()
        .peek(x -> position.incrementAndGet())  // increment every element encounter
        .filter("2"::equals)
        .findFirst()
        .get();

position.get(); // 2
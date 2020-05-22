AtomicInteger i = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);
    IntStream.generate(() -> i.incrementAndGet())
            .parallel()
            .peek(x -> count.incrementAndGet())
            .limit(5)
            .forEach(System.out::println);

    System.out.println("count = " + count);
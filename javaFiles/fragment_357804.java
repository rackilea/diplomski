long start, end;

Stream.of(r1, r2).forEach(r -> {
    start = System.nanoTime();
    r.run();
    end = System.nanoTime();
    System.out.println("Time spent in ns: " + (end - start));
});
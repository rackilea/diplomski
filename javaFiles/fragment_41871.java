System.out.println(IntStream
    .iterate(1, i -> i+1)
    .parallel()
    .peek(i -> { if(i != 1) LockSupport.parkNanos(1_000_000_000); })
    .flatMap(n -> IntStream.iterate(n, i -> i+n))
    .limit(100_000_000)
    .sum()
);
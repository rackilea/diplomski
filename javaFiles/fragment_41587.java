IntStream.range(1, 30)
    .filter(i -> i%13 == 1)
    .peek(i -> System.out.println("processing "+i))
    .parallel()
    .findFirst()
    .ifPresent(i -> System.out.println("result is "+i));
AtomicInteger count = new AtomicInteger();
int product = reduceWithCancelEx(
        IntStream.range(-1000000, 100).filter(x -> x == 0 || x % 2 != 0)
                .parallel().peek(i -> count.incrementAndGet()), 1,
        (a, b) -> a * b, x -> x == 0);
System.out.println("product: " + product + "/count: " + count);
Thread.sleep(1000);
System.out.println("product: " + product + "/count: " + count);
AtomicInteger counter = new AtomicInteger();
ExecutorService es = Executors.newFixedThreadPool(20);
es.invokeAll(Collections.nCopies(20, () -> {
    out.println("1st: " + Thread.currentThread().getName());
    Thread.sleep(100 + new Random().nextInt(1000));
//    Thread.sleep(1000);
    int counterValue = counter.incrementAndGet();
    out.println("2nd: " + Thread.currentThread().getName() + " value: " + counterValue);
    out.println("3rd: " + Thread.currentThread().getName() + " value: " + counterValue);
    return null;
}));
es.shutdown();
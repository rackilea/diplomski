public class FluxTest {
    @Test
    public void testIt() throws InterruptedException {
        Scheduler single = Schedulers.single();

        CountDownLatch latch = new CountDownLatch(1);

        Mono.just("hey")
                .map(this::mapWithException)
                .subscribeOn(single)
                .doOnError(e -> System.out.println("ERROR1: " + e.getMessage()))
                .doOnTerminate((r, e) -> {
                    if (e != null) System.out.println("ERROR3: " + e.getMessage());
                    latch.countDown();
                })
                .subscribe(
                        it -> { throw new RuntimeException("Error for " + it); },
                        ex -> { System.out.println("ERROR2: " + ex.getMessage());}
                        );

        latch.await();
    }

    private String mapWithException(String s) {
        throw new RuntimeException();
    }
}
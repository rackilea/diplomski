private static Runnable measure(Runnable block) {
    return () -> {
        long start = System.nanoTime();
        block.run();
        System.out.printf("Time elapsed: %d Milliseconds\n", (System.nanoTime() - start) / 1000);
    };
}
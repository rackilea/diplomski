private static long staticExecutionTime(final int iterations) {
        final long s1 = System.nanoTime();
        executeNonStatic(iterations);
        final long e1 = System.nanoTime();
        return e1 - s1;
    }
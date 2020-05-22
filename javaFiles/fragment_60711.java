public static void time(String name, int repetitions, Function function,
        int expectedResult) throws Exception {
    long total = 0;
    for (int i = 0; i < repetitions; i++) {
        System.gc();
        long start = System.currentTimeMillis();
        int result = function.call();
        long end = System.currentTimeMillis();
        if (result != expectedResult) {
            System.out.println("Oops, " + name + " is broken");
            return;
        }
        total += end - start;
    }
    System.out.println("Executution of " + name + " took "
            + (total / repetitions) + " ms on average");
}
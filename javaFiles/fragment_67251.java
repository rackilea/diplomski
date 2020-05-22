public static double f(double x) {
    double y = x - 1;
    return -y * y;
}

public static void main(String[] args) {
    final ThreadLocalRandom random = ThreadLocalRandom.current();

    long begin = System.currentTimeMillis();

    double max = IntStream.range(0, 1_000_000_000)
                          .parallel()
                          .mapToDouble(i -> f(random.nextDouble() * 2))
                          .max()
                          .orElse(f(0)) + 2;

    System.out.println("Elapsed time: " + (System.currentTimeMillis() - begin));
    System.out.println("Maximum value y=f(x) is " + max);
}
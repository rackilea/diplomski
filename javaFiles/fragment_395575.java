double min = 100;
double max = 10000000;
{
    long start = 0;
    int runs = 1000000;
    for (int i = -10000; i < runs; i++) {
        if (i == 0)
            start = System.nanoTime();
        double consumption = min + (Math.random() * ((max - min) + 1));

        BigDecimal.valueOf(consumption).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    long time = System.nanoTime() - start;
    System.out.printf("The average time with BigDecimal.valueOf(double) was %,d%n", time / runs);
}
{
    long start = 0;
    int runs = 1000000;
    int min2 = (int) (min * 100);
    int range = (int) ((max - min) * 100);
    Random rand = new Random();
    for (int i = -10000; i < runs; i++) {
        if (i == 0)
            start = System.nanoTime();
        int rand100 = rand.nextInt(range) + min2;
        BigDecimal bd = BigDecimal.valueOf(rand100, 2);
    }
    long time = System.nanoTime() - start;
    System.out.printf("The average time with BigDecimal.valueOf(long, int) was %,d%n", time / runs);

}
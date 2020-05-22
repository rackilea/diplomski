public class Test {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (long i = 0; i < 100_000_000; i++) {
            if (i % 1_000_000 == 0)
                System.out.printf("%9d: %d ms%n", i, System.currentTimeMillis() - start);
            list.add(new Long(i));
        }
        System.out.printf("Total    : %d ms%n", System.currentTimeMillis() - start);
    }
}
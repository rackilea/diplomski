public class Benchmark {

    public static void main(String[] args) {
        long start = System.nanoTime();
        Random random = new Random();
        int count = 1;
        Binom binom = new Binom();
        long[][] mapped = binom.getMapped();
        for (int i = 1; i <= 100_000_000; i++) {
            int n = 1 + random.nextInt(52);
            int r = 1 + random.nextInt(n);
            long result = mapped[n-1][r-1];
            if (result != 0) {
                System.out.println(count++ + ". Binomial for n: " + n + " and r: " + r + " equals " + result + ".");
            } else {
                result = binom.binom(n, r);
                mapped[n-1][r-1] = result;
                System.out.println(count++ + ". Binomial for n: " + n + " and r: " + r + " equals " + result + ".");
            }
        }
        System.out.println("The whole lasted " + ((System.nanoTime() - start)/1_000_000_000) + " seconds.");
    }
}
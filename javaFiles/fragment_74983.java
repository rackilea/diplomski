public class Main {

    public static void main(String[] args) {
        long n = 1234567890123456789L;
        System.out.printf("largest prime factor of %d is %d%n", n, largestPrimeFactorOf(n));
        n = 1234567890123456791L;
        System.out.printf("largest prime factor of %d is %d%n", n, largestPrimeFactorOf(n));
        n = 1234567890123456797L;
        System.out.printf("largest prime factor of %d is %d%n", n, largestPrimeFactorOf(n));
        n = 1234567890123456817L;
        System.out.printf("largest prime factor of %d is %d%n", n, largestPrimeFactorOf(n));
        n = 4611686014132420609L;
        System.out.printf("largest prime factor of %d is %d%n", n, largestPrimeFactorOf(n));
    }

    public static long largestPrimeFactorOf(long n) {
        long last = 1;
        while (n % 2 == 0) {
            System.out.printf("prime factor 2 found%n");
            n /= 2;
            last = 2;
        }
        for (long t = 3; t * t <= n; t += 2) {
            while (n % t == 0) {
                System.out.printf("prime factor %d found%n", t);
                n /= t;
                last = t;
            }
        }
        return n == 1 ? last : n;
    }
}
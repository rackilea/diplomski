import java.math.BigInteger;
import java.util.BitSet;

public class Main {

    static BitSet primes;

    static boolean isPrime(int p) {
        return p > 0 && (p == 2 || (p%2 != 0 && primes.get(p/2)));
    }

    static void generatePrimesUpTo(int n) {
        primes = new BitSet(n/2);

        for(int i = 0; i < primes.size(); i++) {
            primes.set(i, true);
        }

        primes.set(0, false);
        int stop = (int)Math.sqrt(n) + 1;
        int percentageDone = 0, previousPercentageDone = 0;
        System.out.println("generating primes...");
        long start = System.currentTimeMillis();

        for(int i = 0; i <= stop; i++) {
            previousPercentageDone = percentageDone;
            percentageDone = (int)((i + 1.0) / (stop / 100.0));

            if(percentageDone <= 100 && percentageDone != previousPercentageDone) {
                System.out.println(percentageDone + "%");
            }

            if(primes.get(i)) {
                int number = (i * 2) + 1;

                for(int p = number * 2; p < n; p += number) {
                    if(p < 0) break; // overflow
                    if(p%2 == 0) continue;
                    primes.set(p/2, false);
                }
            }
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("finished generating primes ~" + (elapsed/1000) + " seconds");
    }

    private static void test(final int certainty, final int n) {
        int percentageDone = 0, previousPercentageDone = 0;
        long start = System.currentTimeMillis();
        System.out.println("testing isProbablePrime(" + certainty + ") from 1 to " + n);
        for(int i = 1; i < n; i++) {
            previousPercentageDone = percentageDone;
            percentageDone = (int)((i + 1.0) / (n / 100.0));
            if(percentageDone <= 100 && percentageDone != previousPercentageDone) {
                System.out.println(percentageDone + "%");
            }
            BigInteger bigInt = new BigInteger(String.valueOf(i));
            boolean bigIntSays = bigInt.isProbablePrime(certainty);
            if(isPrime(i) != bigIntSays) {
                System.out.println("ERROR: isProbablePrime(" + certainty + ") returns "
                    + bigIntSays + " for i=" + i + " while it " + (isPrime(i) ? "is" : "isn't" ) +
                    " a prime");
                return;
            }
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("finished testing in ~" + ((elapsed/1000)/60) +
                " minutes, no false positive or false negative found for isProbablePrime(" + certainty + ")");
    }

    public static void main(String[] args) {
        int certainty = Integer.parseInt(args[0]);
        int n = Integer.MAX_VALUE;
        generatePrimesUpTo(n);
        test(certainty, n);
    }
}
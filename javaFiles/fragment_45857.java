import java.math.BigInteger;
import java.util.Random;

public class FermatTestExample
{

    private final static Random rand = new Random();

    private static BigInteger getRandomFermatBase(BigInteger n)
    {
        // Rejection method: ask for a random integer but reject it if it isn't
        // in the acceptable set.

        while (true)
        {
            final BigInteger a = new BigInteger (n.bitLength(), rand);
            // must have 1 <= a < n
            if (BigInteger.ONE.compareTo(a) <= 0 && a.compareTo(n) < 0)
            {
                return a;
            }
        }
    }

    public static boolean checkPrime(BigInteger n, int maxIterations)
    {
        if (n.equals(BigInteger.ONE))
            return false;

        for (int i = 0; i < maxIterations; i++)
        {
            BigInteger a = getRandomFermatBase(n);
            a = a.modPow(n.subtract(BigInteger.ONE), n);

            if (!a.equals(BigInteger.ONE))
                return false;
        }

        return true;
    }

    public static void main(String[] args)
    {
        System.out.printf("checkprime(2) is %b%n", checkPrime(BigInteger.valueOf(2L), 20));
        System.out.printf("checkprime(5) is %b%n", checkPrime(BigInteger.valueOf(5L), 20));
        System.out.printf("checkprime(7) is %b%n", checkPrime(BigInteger.valueOf(7L), 20));
        System.out.printf("checkprime(9) is %b%n", checkPrime(BigInteger.valueOf(9L), 20));
    }
}
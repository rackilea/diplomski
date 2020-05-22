public class Main {
    static long AAA = 42L;
    static long BBB = -37L;
    static long TTT = 17206538691L;

    private static long solve() {
        // compute x = inverse(BBB, 1<<64) * (TTT - AAA)

        BigInteger two_64 = BigInteger.ONE.shiftLeft(64);
        BigInteger BBB_inverse = BigInteger.valueOf(BBB).modInverse(two_64);
        return BBB_inverse.multiply(BigInteger.valueOf(TTT - AAA)).longValue();
    }

    public static void main(String[] args) {
        System.out.println(solve());
    }
}
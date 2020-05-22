public class GeometricSequence {
    public static void main(String[] args) {
        //Below method parameters - 5 = n, 1 = count (counter), res = result (Nth number in the GP.
        System.out.println(findNthNumber(2000, 1, new BigInteger("2")));

    }

    public static BigInteger findNthNumber(int n, int count, BigInteger res) {
        return ((count == n)) ? res : findNthNumber(n, count+1, res.multiply(new BigInteger("3")));
    }
}
public class Main {
    public static void main(String[] args) {
        BigInteger thousand = BigInteger.valueOf(1000L);
        for (int i = 999; i > 0; i--)
        {
            thousand = thousand.multiply(BigInteger.valueOf(i));
        }

        System.out.println(thousand.toString());
    }

}
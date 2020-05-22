import java.math.BigInteger;

class Main {
    public static void main(String[] args) {
        BigInteger num = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++) {
            num = num.add(BigInteger.valueOf(i).pow(i));
        }
        BigInteger res = num.mod(new BigInteger("10000000000"));
        System.out.println(res);
    }
}
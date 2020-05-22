import java.math.BigInteger;

class Test {
    public static void main(String[] args) {
        System.out.println(
            new BigInteger("11").modInverse(new BigInteger("26")));
    }
}
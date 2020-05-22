import java.math.*;

public class Test {
    public static void main(String[] args) {
        String hexStr = "1b0ee1e3";
        BigInteger bigInt = new BigInteger(hexStr, 16);
        System.out.println(bigInt); // Prints 453960163
    }
}
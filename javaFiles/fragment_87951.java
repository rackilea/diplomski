import java.math.BigInteger;
import java.util.Scanner;

public class ModuloTest {

    public static void main(String[] args) {
        String s;
        BigInteger n, repeat, remainder;
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        n = in.nextBigInteger();
        BigInteger length = BigInteger.valueOf(s.length());
        repeat = n.divide(length);

        System.out.println(repeat);
    }

}
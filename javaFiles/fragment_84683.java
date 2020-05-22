import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Fastmultiplication {
    public static void main(String[] args) {
        BigInteger m, n;
        try (Scanner sc = new Scanner(System.in)) {
            int in = sc.nextInt();

            ArrayList<BigInteger> al = new ArrayList<>();
            while (in > 0) {
                in--;
                m = sc.nextBigInteger();
                n = sc.nextBigInteger();
                al.add(m.multiply(n));
            }

            al.stream().forEach((bigInteger) -> {
                System.out.println(bigInteger);
            });
        } catch (Exception e) {
            System.out.println("Invalid user input.Going to terminate this program");
        }
    }
}
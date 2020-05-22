import java.math.BigDecimal;

public class TrialCode {

    public static void main(String[] args) {

        BigDecimal a = new BigDecimal("-1.0");
        BigDecimal b = new BigDecimal("0.2");

        for (int i = 0; i < 10; i++) {
            a = a.add(b);
            System.out.println(a);
        }
    }
}
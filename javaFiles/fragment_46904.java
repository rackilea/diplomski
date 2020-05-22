import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("3");
        BigDecimal c = a.divide(b, 2, RoundingMode.HALF_UP);
        System.out.println(a + "/" + b + " = " + c);
    }

}
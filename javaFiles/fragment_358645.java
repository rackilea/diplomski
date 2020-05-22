import org.nevec.rjm.*;
import java.math.BigDecimal;

public class test {
    public static void main(String... args) {
        BigDecimal a = new BigDecimal("1.21");
        BigDecimal b = new BigDecimal("0.5");

        System.out.println(BigDecimalMath.pow(a, b).toString());
    }
}
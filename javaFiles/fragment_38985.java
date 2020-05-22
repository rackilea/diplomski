import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Foo {

    private static final int PRECISION = 5;
    private static final MathContext MATH_CONTEXT = new MathContext(PRECISION, RoundingMode.HALF_UP);

    public static void main(String... args) {
        double a = 62;
        double b = 132; // Doubles used to avoid integer division truncation
        final BigDecimal c = new BigDecimal(a / b, MATH_CONTEXT);
        System.out.println(c); // Prints 0.46970
    }
}
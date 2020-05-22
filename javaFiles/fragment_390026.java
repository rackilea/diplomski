import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        for (long x = 0; x < Long.MAX_VALUE; x++) {
            if (BigDecimal.valueOf(x) != BigDecimal.valueOf(x)) {
                System.out.println("Value for " + x + " wasn't cached");
                break;
            }
        }
    }
}
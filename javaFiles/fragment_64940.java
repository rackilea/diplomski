import java.math.BigDecimal;

public class Compare {

    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal("65.2341234567").setScale(8, BigDecimal.ROUND_FLOOR);
        BigDecimal bd2 = new BigDecimal("65.234123456799").setScale(8, BigDecimal.ROUND_FLOOR);

        System.out.println( "equals " + bd1.equals(bd2));
    }
}
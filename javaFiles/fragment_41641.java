import java.math.*;
import java.text.*;

public class Test {
    public static void main(String[] args) {
        showPrice(new BigDecimal("123.456"));
        showPrice(new BigDecimal("11.12"));
        showPrice(new BigDecimal("10.5"));
        showPrice(new BigDecimal("1.5"));
        showPrice(new BigDecimal("0.5"));
    }

    static void showPrice(BigDecimal price) {
        DecimalFormat format = new DecimalFormat("0.00");
        String text = String.format("Price: $%5s", format.format(price));
        System.out.println(text);
    }
}
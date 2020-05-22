import java.math.*;

public class FactorizerBig {
    private BigDecimal input;

    FactorizerBig(BigDecimal x) {
        input = x;
    }

    public void processBig() {//main algorithm
        String s = "";
        MathContext mc = new MathContext(2); // 2 precision
        BigDecimal idx = new BigDecimal("2");
        BigDecimal z = new BigDecimal("0");
        while ((idx.compareTo(input)) < 1) {
            int comp = (input.remainder(idx, mc)).compareTo(z);
            if (comp != 0) {
                idx = idx.add(BigDecimal.ONE);
            } else {
                s = s.concat(" * " + idx);
                input = input.divide(idx);
                idx = new BigDecimal("2");
            }

        }

        System.out.println(s.substring(2));
    }
}
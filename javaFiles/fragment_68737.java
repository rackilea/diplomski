import java.math.BigDecimal;
import java.math.BigInteger;

public class Sample {

    static int[] toFractionPos(BigDecimal x) {
        String[] parts = x.toString().split("\\.");
        BigDecimal den = BigDecimal.TEN.pow(parts[1].length()); // denominator
        BigDecimal num = (new BigDecimal(parts[0]).multiply(den)).add(new BigDecimal(parts[1])); // numerator
        return reduceFraction(num.intValue(), den.intValue());
    }

    static int[] reduceFraction(int num, int den) {
        int gcd = BigInteger.valueOf(num).gcd(BigInteger.valueOf(den)).intValue(); // greatest
                                                                                   // common
                                                                                   // divisor
        int[] rf = { num / gcd, den / gcd };
        return rf;
    }

    public static void main(String[] args) {
        int[] fraction = toFractionPos(new BigDecimal("0.0001"));
        System.out.println(fraction[0] + "/" + fraction[1]); // 1/10000
    }
}
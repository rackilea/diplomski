import java.math.BigDecimal;

public class Test {
  public static void main(String[] args) {
    final double oneThirdD = 1.0/3;
    final BigDecimal oneThirdBD = new BigDecimal(oneThirdD);
    final double twoThirdsD = oneThirdD + oneThirdD;
    final BigDecimal twoThirdsBD = new BigDecimal(twoThirdsD);
    final BigDecimal exact = twoThirdsBD.add(oneThirdBD);
    final double nextLowerD = Math.nextAfter(1.0, 0);
    final BigDecimal nextLowerBD = new BigDecimal(nextLowerD);
    System.out.println("1.0/3: "+oneThirdBD);
    System.out.println("1.0/3+1.0/3: "+twoThirdsBD);
    System.out.println("Exact sum: "+exact);
    System.out.println("Rounding error rounding up to 1.0: "+BigDecimal.ONE.subtract(exact));
    System.out.println("Largest double that is less than 1.0: "+nextLowerBD);
    System.out.println("Rounding error rounding down to next lower double: "+exact.subtract(nextLowerBD));
  }
}
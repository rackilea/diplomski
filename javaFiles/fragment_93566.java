import java.math.*;

class Example
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BigDecimal bd = new BigDecimal("1.10900");
        bd = bd.divide(new BigDecimal("27"), BigDecimal.ROUND_HALF_DOWN);
        System.out.println("1.109 / 27 using BigDecimal to five places: " + bd);

        double d = 1.109;
        d = d / 27.0;
        System.out.println("1.109 / 27 using double:                    " + d);
    }
}
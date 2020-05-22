import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundingErrors {
    private static final BigDecimal ONE = new BigDecimal( 1 );

    static BigDecimal RecursiveFunction(int num){
        //The num parameter represents the denominator that will be used
        //The recursive function is continually called at lower increments of num

        //If num is one, return 1 and do not call RecursiveFunction again
        if (num == 1) {
            return ONE;
        }
        //Otherwise, return 1/num (in floating point decimal) and call RecursiveFunction with a parameter of num - 1
        else {
            return ONE.divide( new BigDecimal( num ), 100, RoundingMode.CEILING ).add( RecursiveFunction(num - 1) );
        }
    }

    //A Non-recursive version of RecursiveFunction that will be used to test RecursiveFunction
    static BigDecimal NonRecursiveFunction(int num) {
        //The total variable adds up the fractions
        BigDecimal total = new BigDecimal( 0 );
        //While num is greater than zero, add 1/num to total and then subtract 1 from num
        while (num > 0) {
            total = total.add( ONE.divide( new BigDecimal( num ), 100, RoundingMode.CEILING ) );
            num -= 1;
        }
        return total;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println( RecursiveFunction( 1000 ));
        System.out.println( NonRecursiveFunction( 1000 ));
    }
}
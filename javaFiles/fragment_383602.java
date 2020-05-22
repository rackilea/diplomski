import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BigDecimal{
    public static void main(String[] args) {

    Scanner in = new Scanner(System.in); 
    int   number= in.nextInt();
    BigDecimal bd = new BigDecimal(number); 
    BigDecimal rslt = bd.divide(BigDecimal.valueOf(100));
    System.out.println(rslt );


}

}
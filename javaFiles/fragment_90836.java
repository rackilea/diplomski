import java.math.BigDecimal;

public class Java_bigdecimal_signum {
    public static void main(String args[]) {
        String number = "20.15-";
        if(number.endsWith("-")){ 
            number = "-" + number.substring(0, number.length() -1); 
        }
        BigDecimal obj = new BigDecimal(number);
        int i = obj.signum();
        System.out.println("\nobject value : " + obj
                     + "\nmethod generated value : " + i);
    }
}
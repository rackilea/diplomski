import java.text.DecimalFormat;
import java.util.Random;

public class pi {

    public pi() {
        double n=100000000; 
        double w = 0;

        Random rand = new Random();
        DecimalFormat df2 = new DecimalFormat("#,###,###");

        for (int i = 0; i < n; i++) {
            double x = rand.nextFloat(); 
            double y = rand.nextFloat();  
            if ((x*x + y*y) < 1.0) w++;
        }

        System.out.println("w: "+w);//w: 7852372.0
        double numerator = (4*w);
        System.out.printf("4*w: " + (numerator));//4*w: 3.1409488E7
        System.out.println("\nn: " + df2.format(n));//n: 10,000,000
        double pi = numerator / n;

        final String fmt = String.format("%.20f", pi);
        System.out.println(fmt);//3.14094877243042000000

        String pi_string = Double.toString(Math.abs(pi));
        int intP = pi_string.indexOf('.');
        int decP = pi_string.length() - intP - 1;
        System.out.println("decimal places: " + decP);//decimal places: 14
    }

    public static void main(String[] args) {
        new random_pi();
    }
}
import java.text.DecimalFormat;
import java.util.Random;

public class random_pi {

    public random_pi() {

        float x2_store[] = new float[100000000];
        float y2_store[] = new float[100000000];
        int w = 0;

        Random rand = new Random();
        DecimalFormat df2 = new DecimalFormat("#,###,###");

        for (int i = 0; i < x2_store.length; i++) {
            float x2 = (float) Math.pow(rand.nextFloat(), 2);
            x2_store[i] = x2;
            float y2 = (float) Math.pow(rand.nextFloat(), 2);
            y2_store[i] = y2;
        }

        for (int i = 0; i < x2_store.length; i++) {
            if (x2_store[i] + y2_store[i] < 1) {
                w++;
            }
        }

        System.out.println("w: "+w);
        int numerator = (4*w);
        System.out.printf("4*w: " + (numerator));
        System.out.println("\nn: " + df2.format(x2_store.length));
        float pi = ((float)numerator) / x2_store.length;

        String fmt = String.format("%.20f", pi);
        System.out.println(fmt);

        String pi_string = Double.toString(Math.abs(pi));
        int intP = pi_string.indexOf('.');
        int decP = pi_string.length() - intP - 1;
        System.out.println("decimal places: " + decP);
    }

    public static void main(String[] args) {
        new random_pi();
    }
}
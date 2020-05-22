import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.###");
        double[] tests = {2.50, 2.0, 1.3751212, 2.1200};
        for(double d : tests) {
            System.out.println(df.format(d));
        }
    }
}
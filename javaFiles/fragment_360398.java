import java.text.*;

public class Test {

    public static void main(String[] args) {
        // Consider specifying the locale here too
        NumberFormat nf = new DecimalFormat("0.#");

        double[] speeds = { 50, 80, 120, 70.3 };
        for (double speed : speeds) {
            System.out.println(nf.format(speed));
        }
    }

}
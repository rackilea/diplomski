import java.util.Scanner;

public class testprog {
    public static void main (String[] args) {
        double[] dataset = new double[10];

        for (int i = 0; i <= 9 ; i++) {
            Scanner input = new Scanner (System.in);
            System.out.println ("Enter a number: ");
            dataset[i] = input.nextDouble();
        }

        System.out.println ("Average is " + avgarray (dataset));
        System.out.println ("Deviation is " + devequasion (dataset));
    }

    public static double avgarray (double[] arraydata) {
        double sum = 0;
        for (int i = 0; i <= 9 ; i++)
            sum += arraydata[i];
        return sum / 10;
    }

    public static double devequasion (double[] devdata) {
        double subsum = 0;
        for (int i = 0; i <= 9 ; i++)
            subsum += devdata[i] * devdata[i];
        return Math.sqrt ((subsum - avgarray (devdata)) / 9.0);
    }
}
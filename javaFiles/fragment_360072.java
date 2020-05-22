import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class DataRange {
    public static void main(String args[]) {

        try {
            PrintStream myconsole = new PrintStream(new File("out.txt"));
            for (int i = 0; i < 10; i++) {
                double a = Math.sqrt(i);

                int b = 10 + 5;
                double c = Math.cos(i);
                System.out.print("\t" + a);
                myconsole.print("\t" + a);
                System.out.print("\t" + b);
                myconsole.print("\t" + b);
                System.out.print("\t" + c);
                myconsole.print("\t" + c);
                myconsole.print("\n");
                System.out.println("\n");
                System.out.println("Completed");
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
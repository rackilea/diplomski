import java.util.Random;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Random number = new Random();

        while (true) {

            int nmb1 = number.nextInt(10) + 1;
            int nmb2 = number.nextInt(10) + 1;
            int multi = nmb1 * nmb2;
            int question;

            // read the user's input ...
            do {
                question = Integer.parseInt(JOptionPane.showInputDialog("How much is" + nmb1 + "*" + nmb2));

                if (question != multi) {
                    JOptionPane.showMessageDialog(null, "Wrong, try again");
                }
            }
            while (question != multi);
            // .. and repeat until the user types the correct answer

            JOptionPane.showMessageDialog(null, "Right");
        }
    }
}
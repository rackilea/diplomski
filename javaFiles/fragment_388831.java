import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assessment {

    public static void main(String[] args) throws IOException {

        BufferedReader userInput = new BufferedReader(new InputStreamReader(
                System.in));

        String me = "";
        String user1 = "";
        String user2 = "";

        do {
            me = JOptionPane.showInputDialog("Please enter your name");
        } while (me.equals(""));

        System.out.println("Your name is: " + me);

        do {
            user1 = JOptionPane.showInputDialog("Please choose a number");
        } while (user1.equals(""));
        System.out.println("Your number is: " + user1);

        do {
            user2 = JOptionPane
                    .showInputDialog("Please enter your choice of    security, choice1(low) or choice2(high)");

        } while (user2.equals(""));
        String response = (String) System.in.toString();

        if (user2.equals("choice1"))
            JOptionPane.showMessageDialog(null, "your username is: " + me
                    + user1, "Your username", JOptionPane.WARNING_MESSAGE);

    }
}
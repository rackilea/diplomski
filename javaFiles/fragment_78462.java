import javax.swing.*;
import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Say hey");
        String hello = kb.nextLine(); //use kb.nextLine().trim() if you dont want whitespaces
        if (hello.equals("hey")) {
            JDialog dialog = new JDialog();
            dialog.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(dialog, "Hello There");
        }
    }
}
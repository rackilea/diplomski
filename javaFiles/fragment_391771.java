import javax.swing.JOptionPane;

public class Test {
    public static void main(String[] args) {

        String inputString = JOptionPane.showInputDialog(null, "INPUT A NUMER TO DISPLAY");
        int input = Integer.parseInt(inputString);
        System.out.println("User input: " + input);

        JOptionPane.showMessageDialog(null, "User entered " + input);

    }
}
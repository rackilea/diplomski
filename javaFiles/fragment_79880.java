import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class DemoJOptionPane {
    public static void main(String[] args) {
        double value1 = 5, value2 = 3, result;

        JDialog.setDefaultLookAndFeelDecorated(true);
        String symbol = JOptionPane.showInputDialog(null, "+-*/",
                "Enter the symbol", JOptionPane.OK_OPTION);
        if (symbol.equals("+")) {
            result = value1 + value2;
            System.out.println("<h1>The sum is " + result + "</h1>");
        } else if (symbol.equals("-")) {
            result = value1 - value2;
            System.out.println("<h1>The sub is " + result + "</h1>");
        } else if (symbol.equals("*")) {
            result = value1 * value2;
            System.out.println("<h1>The multiplication is " + result + "</h1>");
        } else if (symbol.equals("/")) {
            result = value1 / value2;
            System.out.println("<h1>The division is " + result + "</h1>");
        }
    }
}
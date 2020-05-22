import javax.swing.JComponent;
import javax.swing.JPanel;

public class Test {

    public static void myFunc(JComponent c) {
        if (c instanceof JPanel) {
            System.out.println("yes");
        }
    }
}
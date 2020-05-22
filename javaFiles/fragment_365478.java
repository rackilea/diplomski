import java.awt.EventQueue;
import javax.swing.JOptionPane;

public class I18NDemo {
    public static void main(String[] args) {
        final String message =
            "\u65e5\u672c\u8a9e \u4e2d\u6587 Fran\u00e7ais f\u00fcr";

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, message);
                System.exit(0);
            }
        });
    }
}
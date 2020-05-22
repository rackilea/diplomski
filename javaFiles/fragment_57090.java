import java.lang.Runnable;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class Window1 extends JFrame {

    public static void main(String... args){
        javax.swing.SwingUtilities.invokeLater(new java.lang.Runnable() {
            public void run() {
                Window1 window = new Window1();
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setBounds(200, 200, 400, 300);
                window.setVisible(true);
            }
        });
    }

}
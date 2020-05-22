import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                Container c = f.getContentPane();
                f.setSize(800, 600);
                System.out.println(c.getSize()); // width=0,height=0
                f.addNotify();
                f.revalidate();
                System.out.println(c.getSize()); // width=784,height=562
                f.setVisible(true);
                System.out.println(c.getSize()); // width=784,height=562
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
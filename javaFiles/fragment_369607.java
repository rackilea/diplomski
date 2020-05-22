import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test6 {

    public Test6() {
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JPanel p2 = new JPanel(new GridLayout(13, 1));
        for (int i = 0; i < 13; i++) {
            p2.add(new JButton("Button " + i));
        }
        p1.add(p2);

        JFrame frame = new JFrame("Test Card");
        frame.add(p1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Test6 test = new Test6();
            }
        });
    }
}
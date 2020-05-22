import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** @see http://stackoverflow.com/a/2933256/230513 */
public class Test {

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setLayout(new GridLayout(0, 1));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(createPanel("Some label"));
                frame.add(createPanel("Another label"));
                frame.add(createPanel("Yet another label"));
                frame.pack();
                frame.setSize(frame.getWidth() * 2, frame.getHeight());
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }

            private JPanel createPanel(String s) {
                JPanel p = new JPanel(new BorderLayout());
                p.add(new JLabel(s, JLabel.LEFT), BorderLayout.WEST);
                p.add(new JCheckBox(), BorderLayout.EAST);
                p.setBorder(BorderFactory.createLineBorder(Color.blue));
                return p;
            }
        });
    }
}
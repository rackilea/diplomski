import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestJFrame {

    public static void main(final String args[]) {
        JFrame jFrame1 = new JFrame();
        jFrame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame1.add(new JLabel("First JFrame"));
        jFrame1.pack();

        final JFrame jFrame2 = new JFrame();
        jFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame2.add(new JLabel("Second JFrame"));
        jFrame2.pack();

        jFrame1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(final WindowEvent e) {
                jFrame2.setVisible(true);
            }
        });

        jFrame1.setVisible(true);

    }

}
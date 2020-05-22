import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LabelUpdater {
    public static void main(String[] args) {
        LabelUpdater me = new LabelUpdater();
        me.process();
    }

    private JLabel label;

    private void process() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new JPanel(new BorderLayout()));
                label = new JLabel(createLabelString(5));
                frame.getContentPane().add(label);
                frame.setSize(300, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        snooze();
        for (int i = 5; i >= 1; i--) {
            final int time = i - 1;
            snooze();
            SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                    label.setText(createLabelString(time));

                }

            });

        }

    }

    private void snooze() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    private String createLabelString(int nbSeconds) {
        return "Still " + nbSeconds + " seconds to wait";
    }
}
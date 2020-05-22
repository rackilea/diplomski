import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class FrameTest extends JFrame {

    private static FrameTest marco;
    private static FrameTest polo;

    private static class MyPanel extends JPanel {

        public MyPanel() {
            super(true);
            final JToggleButton b = new JToggleButton("Test");
            b.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (b.isSelected()) {
                        polo.setLocation(100, 100);
                        polo.setVisible(true);
                    }
                    else {
                        polo.setVisible(false);
                        polo.setLocation(Short.MIN_VALUE, Short.MIN_VALUE);
                    }
                }
            });
            this.add(b);
        }
    }

    public FrameTest(String title) {
        super(title);
        this.setLayout(new BorderLayout());
        this.add(new MyPanel());
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(final String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                marco = new FrameTest("Marco");
                marco.setLocationRelativeTo(null);
                marco.setVisible(true);
                polo = new FrameTest("Polo");
                polo.setLocation(Short.MIN_VALUE, Short.MIN_VALUE);
            }
        });
    }
}
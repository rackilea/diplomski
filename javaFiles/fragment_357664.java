import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import org.jdesktop.swingx.VerticalLayout;

public class VerticalLayoutTest {

    public static void main(String[] args) {
        new VerticalLayoutTest();
    }

    public VerticalLayoutTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {

            setLayout(new VerticalLayout());

            JPanel outter = new JPanel(new BorderLayout());
            outter.setBorder(new LineBorder(Color.BLACK));
            outter.add(new JLabel("Outter 1"), BorderLayout.NORTH);
            JPanel inner = new JPanel(new GridBagLayout());
            inner.setBackground(Color.GREEN);
            inner.add(new JLabel("Inner 1"));
            outter.add(inner);
            add(outter);

            inner.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    Component component = e.getComponent();
                    component.setVisible(false);
                    component.invalidate();
                    component.validate();
                    revalidate();
                    repaint();
                }

            });

            add(Box.createVerticalGlue());

            outter = new JPanel(new BorderLayout());
            outter.setBorder(new LineBorder(Color.BLACK));
            outter.add(new JLabel("Outter 1"), BorderLayout.NORTH);
            inner = new JPanel(new GridBagLayout());
            inner.setBackground(Color.GREEN);
            inner.add(new JLabel("Inner 1"));
            outter.add(inner);
            add(outter);

        }
    }
}
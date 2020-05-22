import java.awt.Color;
import static java.awt.Color.BLACK;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class JFrameTest extends JFrame {

    public JFrameTest() {
        setSize(500, 500);
        setTitle("Hello :D");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel pane = new JPanel() {
            @Override
            public boolean isOpaque() {
                return false;
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(Color.RED);
                g2d.fillOval(195, 195, 10, 10);
                g2d.dispose();
            }

        };
        setGlassPane(pane);
        pane.setVisible(true);
        setVisible(true);
    }

    public static class JPanelTest extends JPanel {

        public JPanelTest() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.ipadx = 100;
            gbc.ipady = 0;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.insets = new Insets(200, 200, 0, 0);
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            setBackground(BLACK);
            setOpaque(true);
            JButton btn = new JButton("Hello");
            btn.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentMoved(ComponentEvent e) {
                    System.out.println(btn.getLocation());
                }
            });
            add(btn, gbc);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrameTest T = new JFrameTest();
                JPanelTest Jp1 = new JPanelTest();
                T.add(Jp1);
            }
        });
    }
}
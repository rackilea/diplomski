import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestBlink {

    public static void main(String[] args) {
        new TestBlink();
    }

    public TestBlink() {
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

        private Timer blink1;
        private Timer blink2;

        private boolean light1 = false;
        private boolean light2 = false;

        public TestPane() {

            blink1 = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    light1 = !light1;
                    repaint();
                }
            });
            blink2 = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    light2 = !light2;
                    repaint();
                }
            });

            blink1.start();
            blink2.start();

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int radius = 20;
            int x = (getWidth() - (radius * 2)) / 2;
            int y = (getHeight() - (radius * 2)) / 2;

            Ellipse2D signal1 = new Ellipse2D.Float(x, y, radius, radius);
            Ellipse2D signal2 = new Ellipse2D.Float(x + radius, y, radius, radius);

            g2d.setColor(Color.RED);
            g2d.draw(signal1);
            if (light1) {
                g2d.fill(signal1);
            }
            g2d.setColor(Color.GREEN);
            g2d.draw(signal2);
            if (light2) {
                g2d.fill(signal2);
            }

            g2d.dispose();
        }
    }
}
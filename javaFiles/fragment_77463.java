import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RepaintTest {

    public static void main(String[] args) {
        new RepaintTest();
    }

    public RepaintTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                TestPane tp = new TestPane();
                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(tp);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                Thread thread = new Thread(new Repainter(tp));
                thread.setDaemon(true);
                thread.start();
            }
        });
    }

    public class Repainter implements Runnable {

        private JPanel panel;

        public Repainter(JPanel panel) {
            this.panel = panel;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
                panel.repaint();
            }
        }

    }

    public class TestPane extends JPanel {

        private int repaints = 0;

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics g2d = (Graphics2D) g.create();
            repaints++;
            FontMetrics fm = g2d.getFontMetrics();
            String text = Integer.toString(repaints);
            int x = (getWidth() - fm.stringWidth(text)) / 2;
            int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
            g2d.drawString(text, x, y);
            g2d.dispose();
        }

    }

}
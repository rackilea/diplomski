import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestFullScreen {

    public static void main(String[] args) {
        new TestFullScreen();
    }

    public TestFullScreen() {
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

                final Screen s = new Screen();
                DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
                s.setFullScreen(dm, frame);

                Timer timer = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        s.restoreScreen();
                    }
                });
                timer.start();
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setBackground(Color.GREEN);
            setForeground(Color.WHITE);
            setFont(new Font("Arial", Font.PLAIN, 24));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int width = getWidth();
            int height = getHeight();
            FontMetrics fm = g2d.getFontMetrics();
            String text = "It's not easy to be green";
            int x = (width - fm.stringWidth(text)) / 2;
            int y = ((height - fm.getHeight()) / 2) + fm.getAscent();
            System.out.println(width + "x" + height);
            System.out.println(x + "x" + y);
            g2d.drawString(text, x, y);
            g2d.dispose();
        }
    }

    public class Screen {

        private GraphicsDevice vc;

        public Screen() {
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            vc = env.getDefaultScreenDevice();
        }

        public void setFullScreen(DisplayMode dm, JFrame window) {
            window.setUndecorated(true);
            window.setResizable(false);
            vc.setFullScreenWindow(window);

            if (dm != null && vc.isDisplayChangeSupported()) {
                try {
                    vc.setDisplayMode(dm);
                } catch (Exception e) {
                }
            }
        }

        public Window getFullScreen() {
            return vc.getFullScreenWindow();
        }

        public void restoreScreen() {
            Window w = vc.getFullScreenWindow();
            if (w != null) {
                w.dispose();
            }
            vc.setFullScreenWindow(null);
        }
    }
}
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TestRecording {

    public static class MyPanel extends JPanel {

        private BufferedImage buffer = new BufferedImage(3000, 100, BufferedImage.TYPE_INT_RGB);

        private int width = 0;

        private int lastY = 50;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (width > 0) {
                BufferedImage sub = buffer.getSubimage(0, 0, width, buffer.getHeight());
                g.drawImage(sub, 0, Math.max(0, (getHeight() - buffer.getHeight()) / 2), this);
            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(width, 100);
        }

        protected void drawSomething() {
            // Here need to handle growing image
            Graphics g = buffer.getGraphics();
            g.setColor(Color.GREEN);
            int y = new Random().nextInt(buffer.getHeight());
            g.drawLine(width, lastY, width + 1, y);
            lastY = y;
            width += 1;
            Rectangle r = new Rectangle();
            r.x = getWidth();
                    // Lame hack to auto-scroll to the end
            scrollRectToVisible(r);
            revalidate();
            repaint();
        }
    }

    protected void initUI() {
        JFrame frame = new JFrame(TestRecording.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final MyPanel p = new MyPanel();
        JScrollPane scrollpane = new JScrollPane(p);
        frame.add(scrollpane);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Timer t = new Timer(20, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                p.drawSomething();
            }
        });
        t.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestRecording().initUI();
            }
        });
    }
}
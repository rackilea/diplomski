import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Test {

    Timer timer;

    Test() {
        int width = 854;
        int height = 480;
        String title = "Test";
        BufferedImage bufferedImage = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_RGB);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                Graphics2D graphics2D = (Graphics2D) graphics;
                // when you have an ImageObserver, may as well use it
                //graphics2D.drawImage(bufferedImage, 0, 0, null);
                graphics2D.drawImage(bufferedImage, 0, 0, this);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(width,height);
            }
        };
        frame.add(panel);
        frame.pack();
        frame.setTitle(title);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        int size = height / 3;

        ActionListener animationListener = new ActionListener() {

            int x = -size;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x <= width) {
                    Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
                    graphics2D.setColor(Color.RED);
                    graphics2D.fill(new Rectangle2D.Double(x, 0, size, size));
                    graphics2D.setColor(Color.GREEN);
                    graphics2D.fill(new Rectangle2D.Double(x, size, size, size));
                    graphics2D.setColor(Color.BLUE);
                    graphics2D.fill(new Rectangle2D.Double(x, 2 * size, size, size));
                    graphics2D.dispose();
                    panel.repaint();
                    ++x;
                } else {
                    timer.stop();
                    frame.dispose();
                }
            }
        };
        timer = new Timer(10, animationListener);
        timer.start();
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            new Test();
        };
        SwingUtilities.invokeLater(r);
    }
}
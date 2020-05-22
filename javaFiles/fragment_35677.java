import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Ball extends JPanel {

    int x, y, w, h;
    BufferedImage jimImg;

    public Ball(int xLoc, int yLoc, int width, int height) {
        x = xLoc;
        y = yLoc;
        w = width;
        h = height;
        try {
            jimImg = ImageIO.read(
                    Ball.class.getResource("/resources/stackoverflow5.png"));
            System.out.println(jimImg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(jimImg, x, y, w, h, this);
    }

    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new Ball(50, 50, 100, 100));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Board extends JPanel {

    Ball ball = new Ball(50, 50, 200, 200);

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.drawBall(g);
    }

    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new Board());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}

class Ball {

    int x, y, w, h;
    BufferedImage jimImg;

    public Ball(int xLoc, int yLoc, int width, int height) {
        x = xLoc;
        y = yLoc;
        w = width;
        h = height;
        try {
            jimImg = ImageIO.read(
                    Board.class.getResource("/resources/stackoverflow5.png"));
            System.out.println(jimImg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void drawBall(Graphics g) {
        g.drawImage(jimImg, x, y, w, h, null);
    }
}
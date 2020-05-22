import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import java.net.URL;

public class Game extends JPanel {

    Random random = new Random();
    final String[] image_path = new String[]{
        "http://i.stack.imgur.com/gJmeJ.png",
        "http://i.stack.imgur.com/IHARa.png",
        "http://i.stack.imgur.com/wCF8S.png",
        "http://i.stack.imgur.com/T5uTa.png"
    };
    private static final long serialVersionUID = 1L;
    //what the balls are like
    public final static int START_BALLS = 40;
    public static Vector<Ball> balls = new Vector<Ball>();
    private Image img;
    // A Graphics instance is typically transient.
    // There is rarely, if ever, a need to store them
    //private Graphics graphics;

    public Game() {
        for (int i = 0; i < image_path.length; i++) {
            balls.add(new Ball(image_path[i]));
        }
        //I have no idea what you were trying to achieve here, but it fails horribly
        // img = createImage(null);
        img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        // graphics = img.getGraphics();
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        };
        Timer timer = new Timer(400, al);
        timer.start();
    }

    @Override  // very handy!
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // g.drawImage(img, 0, 0, null);  A JPanel IS A ImageObserver
        g.drawImage(img, 0, 0, this);
        Ball b = (Ball) balls.get(random.nextInt(4));
        b.draw(g);
    }

    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame("Game");
                f.add(new Game());
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See https://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // should be done last, to avoid flickering, moving,
                // resizing artifacts.
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}

class Ball {

    String randomBalls;
    public Image image;

    public Ball(String url) {
        try {
            image = ImageIO.read(new URL(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        g.drawImage(image, 0, 0, null, null);
    }
}
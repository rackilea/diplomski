import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Die extends JPanel {

//current number of die.  Starts with 1.
    private int number;
//boolean showing whether user wants to roll this die
    private boolean userSelectToRoll;
    private Random generate;
    private boolean rolled;
    private Graphics2D g;
    private BufferedImage image;

    public Die() {
        this.userSelectToRoll = true;
        this.generate = new Random();
        this.rolled = false;
        try {
            image = ImageIO.read(Die.class.getResource("stackoverflow5.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, this);
    }

    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new Die());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
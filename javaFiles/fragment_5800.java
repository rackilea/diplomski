import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Lives extends JPanel {
    private int lives;
    private ImageIcon gameOverImage;

    public Lives() {
        try {
            gameOverImage = new ImageIcon(new URL("http://imgup.motion-twin.com/dinorpg/0/f/77acf80b_989624.jpg"));
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        lives = 5;
    }

    public void removeLife() {
        if (lives > 0) {
            lives--;
            System.out.println("Left lives: " + lives);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (lives > 0) {
            System.out.println("Still have " + lives + " lives");
            g.setColor(Color.WHITE);
            g.fillRect(5 * 20, 25 * 20, 100, 30);
            g.setColor(Color.BLACK);
            String result = "Lives: " + lives;
            g.drawString(result, 6 * 20, 26 * 20);
        } else if (gameOverImage != null) {
            System.out.println("Game over");
            int x = (getWidth() - gameOverImage.getIconWidth()) / 2;
            int y = (getHeight() - gameOverImage.getIconHeight()) / 2;
            g.drawImage(gameOverImage.getImage(), x, y, gameOverImage.getIconWidth(), gameOverImage.getIconHeight(), this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame(Lives.class.getSimpleName());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                final Lives lives = new Lives();
                frame.add(lives);
                frame.pack();
                frame.setVisible(true);
                // Dummy timer that reduces the lives every second. For demo purposes only of course
                Timer t = new Timer(1000, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        lives.removeLife();
                    }
                });
                t.start();
            }
        });
    }
}
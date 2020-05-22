import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class Game2 extends JPanel {
    private static final int PREF_W = 1000;
    private static final int PREF_H = 800;
    private static final int TIMER_DELAY = 20;
    private List<Asteroid2> asteroids = new ArrayList<>();

    public Game2() {
        setBackground(Color.BLACK);
        int rows = 5;
        int cols = 5;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Asteroid2 asteroid = new Asteroid2();
                asteroid.setX(j * (PREF_W / cols));
                asteroid.setY(i * (PREF_H / rows));
                asteroids.add(asteroid);
            }
        }
        new Timer(TIMER_DELAY, e -> {
            for (Asteroid2 asteroid2 : asteroids) {
                asteroid2.move();
            }
            repaint();
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Asteroid2 asteroid : asteroids) {
            asteroid.draw(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        Game2 mainPanel = new Game2();

        JFrame frame = new JFrame("Game2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}
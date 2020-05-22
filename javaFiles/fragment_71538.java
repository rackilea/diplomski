import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.*;

public class RandomBrightColors extends JPanel {
    private static final int PREF_W = 500;
    private static final int PREF_H = PREF_W;
    private static final int RECT_W = 30;
    private static final int RECT_H = RECT_W;
    private static final float MIN_BRIGHTNESS = 0.8f;
    private Random random = new Random();

    public RandomBrightColors() {
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 100; i++) {
            g.setColor(createRandomBrightColor());
            int x = random.nextInt(getWidth() - RECT_W);
            int y = random.nextInt(getHeight() - RECT_H);
            g.fillRect(x, y, RECT_W, RECT_H);
        }
    }

    private Color createRandomBrightColor() {
        float h = random.nextFloat();
        float s = random.nextFloat();
        float b = MIN_BRIGHTNESS + ((1f - MIN_BRIGHTNESS) * random.nextFloat());
        Color c = Color.getHSBColor(h, s, b);
        return c;
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        RandomBrightColors mainPanel = new RandomBrightColors();

        JFrame frame = new JFrame("RandomBrightColors");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}
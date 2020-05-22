import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MyMonopoly extends JPanel {
    private static final String IMG_PATH = "http://dl.gamesradar.com/photos/gameopoly/monopoly_original.jpg";
    private static final int PREF_W = 900;
    private static final int PREF_H = PREF_W;
    private BufferedImage board = null;

    public MyMonopoly() throws IOException {
        URL url = new URL(IMG_PATH);
        board = ImageIO.read(url);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (board != null) {
            g.drawImage(board, 0, 0, getWidth(), getHeight(), this);
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
        MyMonopoly mainPanel = null;
        try {
            mainPanel = new MyMonopoly();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        JFrame frame = new JFrame("My Monopoly");
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
package tm;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import tm.Screen.Settings;

public class Game extends JPanel implements Runnable {
    // private Setting Settings;

    private Thread t;
    private BufferedImage offscreenImage;
    private Graphics offscr;

    public void run() {
        while (true) {
            repaint();

            try {
                Thread.sleep(1000 / 30);
            } catch (InterruptedException e) {
            }
        }
    }

    public void paint(Graphics g) {

        if (offscreenImage == null) {

            offscreenImage = (BufferedImage) createImage(Settings.GAME_WIDTH,
                    Settings.GAME_HEIGHT);
        }
        offscr = offscreenImage.getGraphics();
        offscr.setColor(Color.black);
        offscr.fillRect(0, 0, Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        offscr.setColor(Color.white);
        offscr.drawString("Lolz", 10, 10);

        g.drawImage(offscreenImage, 0, 0, this);
    }

    public void update(Graphics g) {
        paint(g);
    }


    public void init() {
        t = new Thread(this);
        t.start();
    }

    public Game() {
        init();
    }
}
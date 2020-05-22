import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class t extends Applet implements Runnable {

    BufferedImage   bufferI;
    final int       WIDTH   = 500, HEIGHT = 500;
    public void init() {
        bufferI = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferI.getGraphics();
        g.setColor(Color.GREEN);
        g.fillRect(0,0,WIDTH,HEIGHT);
        g.dispose();
        (new Thread(this)).start();
    }
    public void run() {
        while (true){
            if (bufferI.getRGB(WIDTH/2, HEIGHT/2)==0xFF000000) System.out.println("BLACK");
        }
    }
    public void paint(Graphics g) {
        g.drawImage(bufferI, 0, 0, this);
    }
}
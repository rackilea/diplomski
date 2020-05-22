import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable{

BufferedImage img;
public Panel() {
    super(true);
    new Thread(this).start();
}

public void paintComponent(Graphics g) {
    super.paintComponent(g);

    if(img != null){
        synchronized(this){
            g.drawImage(img, 0, 0, 640, 480, this);
        }
    }
}

public void run(){
    while(true){
        try {
            synchronized(this){
                img = ImageIO.read(new File("webcam.jpg"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        repaint();

        try {
            Thread.sleep((long) (1000.0/30));
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
}
import java.applet.*;
import java.awt.*;


public class Test extends Applet implements Runnable{

public boolean isRunning = false;
public int radius = 25;


public void start() {
    isRunning = true;
    new Thread(this).start();
}

public void stop() {
    isRunning = false;
}

public void paint(Graphics g) {
    //Create Graphics2D object, cast g as a Graphics2D
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.ORANGE);
    g2d.fillRect(0, 0, 150, 150);

    g2d.setColor(Color.BLACK);
    g2d.drawOval((150/2 - radius), (150/2 - radius), radius * 2, radius * 2);
}

public void run() {

    while (isRunning) {
        repaint();
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


}
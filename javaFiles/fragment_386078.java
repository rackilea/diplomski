import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class ClockFrame extends JFrame {

    public ClockFrame() {
        JPanel panel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setSize(1000, 1000);
        panel.setSize(getWidth(), getHeight());
        // this is NOT the way to go
        //panel.setLayout(null);//!important
        panel.setLayout(new GridLayout());
        setResizable(false);
        panel.setBackground(Color.RED);
        SecondHand sHand = new SecondHand("./res/icon/sechand.png", new Point(450, 300), panel);
        panel.add(sHand); // THIS is impoertant
        // this should be done after all components are added!
        setVisible(true);
    }

    public static void main(String[] a) {
        ClockFrame c = new ClockFrame();
    }
}

class SecondHand extends JComponent implements Runnable {

    private JPanel fpanel;
    private BufferedImage bImage;
    private Thread secThread;
    private Point center;
    double radPerSec = Math.PI / 648000;

    public SecondHand(String path, Point p, Object o) {
        try {
            bImage
                    = new BufferedImage(900, 600, BufferedImage.TYPE_INT_RGB);
            //ImageIO.read(new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //setLocation((int)p.getX(),(int)p.getY());
        setLocation(0, 0);
        center = p;
        ((JPanel) o).add(this);
        fpanel = (JPanel) o;

        secThread = new Thread(this);
        secThread.start();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                Graphics2D g2 = (Graphics2D) getGraphics();
                g2.drawImage(bImage, 0, 0, null);
                //fpanel.repaint();

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}
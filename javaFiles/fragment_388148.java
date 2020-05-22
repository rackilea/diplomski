import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class main
{
    public static void main(String [] args) throws InterruptedException
    {
        JFrame f = new JFrame("Title");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas testing = new Canvas();

        f.add(testing);
        f.setSize(800, 600);
        f.setVisible(true);
    }
}

class Canvas extends JPanel
{

    BufferedImage image;

    Canvas() {
        image = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
        JLabel picLabel = new JLabel(new ImageIcon(image));
        System.out.println("Added pic");
        add(picLabel);
    }

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(Color.BLACK);
        g.fillRect(25, 25, 100, 30);

        g.setColor(new Color(190,81,215));
        g.fillRect(25, 68, 10, 10);

        g.setColor(Color.RED);
        g.drawString("Matt is da best", 100, 10);
    }
}
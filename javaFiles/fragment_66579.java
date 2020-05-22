import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PremultipliedAlphaTest
{
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }    

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new PremultipliedAlphaTestPanel());
        f.setSize(550,500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}


class PremultipliedAlphaTestPanel extends JPanel
{
    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        BufferedImage imageS = createImage(BufferedImage.TYPE_INT_ARGB);
        BufferedImage imageP = createImage(BufferedImage.TYPE_INT_ARGB_PRE);

        Kernel kernel = new Kernel(1, 3, 
            new float[]{ 1.0f / 3.0f, 1.0f / 3.0f, 1.0f / 3.0f });
        ConvolveOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_ZERO_FILL, null);
        BufferedImage resultS = op.filter(imageS, null);
        BufferedImage resultP = op.filter(imageP, null);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Monospaced", Font.PLAIN, 12));

        g.drawString("Straight:", 10, 40);

        print(g, 2, 1, imageS.getRGB(0, 0));
        print(g, 2, 2, imageS.getRGB(0, 1));
        print(g, 2, 3, imageS.getRGB(0, 2));

        print(g, 7, 2, resultS.getRGB(0, 1));


        g.drawString("Premultiplied:", 10, 240);

        print(g, 2, 5, imageP.getRGB(0, 0));
        print(g, 2, 6, imageP.getRGB(0, 1));
        print(g, 2, 7, imageP.getRGB(0, 2));

        print(g, 7, 6, resultP.getRGB(0, 1));

        g.scale(50, 50);

        g.drawImage(imageS,  1, 1, null);
        g.drawImage(resultS, 6, 1, null);

        g.drawImage(imageP,  1, 5, null);
        g.drawImage(resultP, 6, 5, null);
    }

    private static void print(Graphics2D g, int px, int py, int argb)
    {
        g.drawString(stringFor(argb), px*50+5, py*50+25);
    }


    private static String stringFor(int argb)
    {
        int a = (argb >> 24) & 0xFF;
        int r = (argb >> 16) & 0xFF;
        int g = (argb >>  8) & 0xFF;
        int b = (argb      ) & 0xFF;
        float fa = a / 255.0f;
        float fr = r / 255.0f;
        float fg = g / 255.0f;
        float fb = b / 255.0f;
        return String.format(Locale.ENGLISH,
            "%4.2f %4.2f %4.2f %4.2f", fa, fr, fg, fb);
    }

    private static BufferedImage createImage(int type)
    {
        BufferedImage b = new BufferedImage(1,3, type);
        Graphics2D g = b.createGraphics();
        g.setColor(new Color(1.0f,0.0f,0.0f,1.0f));
        g.fillRect(0, 0, 1, 1);
        g.setColor(new Color(0.0f,0.0f,0.0f,0.0f));
        g.fillRect(0, 1, 1, 1);
        g.setColor(new Color(0.0f,0.0f,0.0f,0.0f));
        g.fillRect(0, 2, 1, 1);
        g.dispose();
        return b;
    }
}
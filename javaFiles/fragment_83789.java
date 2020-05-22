import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StylistButton extends JButton implements MouseListener
{
    boolean mouseIn = false;

    public StylistButton(String s)
    {
        addMouseListener(this);
        setBorderPainted(false);
        setContentAreaFilled(false);        
    }

    protected static ImageIcon createImageIcon(String path)
    {
        URL imgURL = TextSamplerDemo.class.getResource(path);
        if (imgURL != null)
        {
            return new ImageIcon(imgURL);
        }
        else
        {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }   


    protected void paintComponent(Graphics g)
    {
        // set button big enough so we can see the rounding curve.
        setSize(60, 40);
        ImageIcon netbeans = createImageIcon("netbeans.png");

        if (netbeans != null)
        {
            setIcon(netbeans);
        }

        setIcon(netbeans);
        Color[] gradients;
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);

        if(getModel().isRollover())
        {
            g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
            Shape firstClip = g.getClip();
            RoundRectangle2D rect = new RoundRectangle2D.Double();
            double arc = Math.ceil(getSize().getHeight() / 3);
            rect.setRoundRect(0, 0, Math.ceil(getSize().getWidth()), Math.ceil(getSize().getHeight()), arc, arc);
            Area secondClip = new Area(getBounds());
            secondClip.subtract(new Area(rect));
            Area finalClip = new Area(firstClip);
            finalClip.subtract(secondClip);
            g2.setClip(finalClip);
            super.paintComponent(g2);           

            gradients = new Color[] { new Color(184, 207, 229), new Color(122, 138, 153), new Color(184, 207, 229) };

            for(int i = 0; i < gradients.length; i++)
            {
                arc -= 2;
                g2.setColor(gradients[i]);          
                g2.drawRoundRect(i+1, i+1, (int)Math.ceil(getSize().getWidth()-2)-(i*2), (int)Math.ceil(getSize().getHeight()-2)-(i*2), (int)arc, (int)arc);
            }
        }
        else if (getModel().isSelected())
        {
            // TODO, leave a permanent focus mark here.
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());

        StylistButton sButton = new StylistButton("stylistButton");

        frame.getContentPane().add(sButton);

        frame.setSize(250, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

}
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class BackgroundImage extends JPanel{

    private BufferedImage img;
    private URL rUrl;
    public BackgroundImage()
    {
        super();

        try{
            rUrl = getClass().getResource("formBackground.png");

            img = ImageIO.read(rUrl);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        super.setBounds(0,0,600,600);

    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

    }

}
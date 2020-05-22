import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import java.net.*;

public class ImageReload extends JFrame implements ActionListener
{
    JLabel timeLabel;
    JLabel imageLabel;
    ImageIcon icon = new ImageIcon("timeLabel.jpg");

    public ImageReload()
    {
        timeLabel = new JLabel( new Date().toString() );
        imageLabel = new JLabel( timeLabel.getText() );
        getContentPane().add(timeLabel, BorderLayout.NORTH);
        getContentPane().add(imageLabel, BorderLayout.SOUTH);

        javax.swing.Timer timer = new javax.swing.Timer(1000, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e)
    {
        timeLabel.setText( new Date().toString() );

        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    String imageName = "timeLabel.jpg";
                    BufferedImage image = ScreenImage.createImage(timeLabel);
                    ScreenImage.writeImage(image, imageName);

                    //  This works using ImageIO

//                  imageLabel.setIcon( new ImageIcon(ImageIO.read( new File(imageName) ) ) );

                    //  Or you can flush the image

                    ImageIcon icon = new ImageIcon(imageName);
                    icon.getImage().flush();
                    imageLabel.setIcon( icon );
                }
                catch(Exception e)
                {
                    System.out.println( e );
                }
            }
        });
    }

    public static void main(String[] args)
    {
        ImageReload frame = new ImageReload();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    }
}
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Module5Assignment2 extends JApplet
{
    public void init()
    {
        try
        {
            InputStream stream = getClass().getResourceAsStream("sample.jpg");
            if (stream == null)
            {
                System.out.println("Resource not found");
            }
            else
            {
                myPicture = ImageIO.read(stream);
                icon = new ImageIcon(myPicture);
                label = new JLabel(icon);
                add(label, BorderLayout.NORTH);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        add(bio);
        add(bio, BorderLayout.CENTER);

        pane.add(play);
        getContentPane().add(pane, BorderLayout.SOUTH);
        play.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    FileInputStream FIS = new FileInputStream("sample.mp3");
                    // player = new Player (FIS);
                    // player.play();
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String args[])
    {
        JFrame frame = new JFrame("");
        // ******PRETTY SURE I NEED TO ADD SOMETHING HERE*************
        Module5Assignment2 contents = new Module5Assignment2();
        frame.getContentPane().add(contents);
        contents.init();
        // *************************************************************

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.show();
    }

    private JPanel pane = new JPanel();
    private TextArea bio = new TextArea(
        "This is the bio of Christian Sprague; he doesn't like typing things.");
    private JButton play = new JButton("Play");
    private Image myPicture;
    private ImageIcon icon;
    private JLabel label;
    // private Player player;

}
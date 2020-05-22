import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AppletOrApplicationExample extends JApplet
{
    @Override
    public void init()
    {
        add(new AppletOrApplicationMainComponent());
    }

    public static void main(String args[])
    {
        JFrame frame = new JFrame("");
        frame.getContentPane().add(new AppletOrApplicationMainComponent());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

class AppletOrApplicationMainComponent extends JPanel
{
    public AppletOrApplicationMainComponent()
    {
        super(new BorderLayout());

        InputStream stream = getClass().getResourceAsStream("sample.jpg");
        if (stream == null)
        {
            add(new JLabel("Resource not found"), BorderLayout.NORTH);
        }
        else
        {
            try
            {
                BufferedImage image = ImageIO.read(stream);
                add(new JLabel(new ImageIcon(image)), BorderLayout.NORTH);
            }
            catch (IOException e1)
            {
                add(new JLabel("Could not load image"), BorderLayout.NORTH);
            }
        }

        JTextArea textArea = new JTextArea("Text...");
        add(textArea, BorderLayout.CENTER);

        JButton button = new JButton("Button");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                doSomething();
            }
        });
        add(button, BorderLayout.SOUTH);
    }

    private void doSomething()
    {
        System.out.println("Button was clicked");
    }
}
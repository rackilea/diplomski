import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class ModifiableBackgroundFrame extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private ImageIcon image;
    private JPanel pan;
    private JButton btn;
    private int count = 0;
    private static final String[] images = 
        {"http://www.dvd-ppt-slideshow.com/images/ppt-background/background-3.jpg",
        "http://www.psdgraphics.com/wp-content/uploads/2009/02/abstract-background.jpg",
        "http://hdwallpaperpics.com/wallpaper/picture/image/background.jpg",
        "http://www.highresolutionpics.info/wp-content/uploads/images/beautiful-on-green-backgrounds-for-powerpoint.jpg"};

    public ModifiableBackgroundFrame()
    {
        super("The title");

        image = new ImageIcon();

        btn = new JButton("Change background");
        btn.setFocusPainted(false);
        btn.addActionListener(this);
        pan = new JPanel()
        {
            private static final long serialVersionUID = 1L;

            @Override
            public void paintComponent(Graphics g)
            {
                g.drawImage(image.getImage(), 0, 0, null);
            }
        };
        pan.setPreferredSize(new Dimension(400, 400));

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(pan, BorderLayout.CENTER);
        contentPane.add(btn, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new ModifiableBackgroundFrame();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        btn.setEnabled(false);
        btn.setText("Loading...");
        new SwingWorker<Image, Void>()
        {
            @Override
            protected Image doInBackground() throws Exception
            {
                return ImageIO.read(new URL(images[count++ % 4]));
            }

            @Override
            protected void done()
            {
                try
                {
                    image.setImage(get());
                    pan.repaint();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                catch(ExecutionException e)
                {
                    e.printStackTrace();
                }
                btn.setText("Change background");
                btn.setEnabled(true);
            }
        }.execute();
    }
}
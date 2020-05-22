import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ImageSequence {
    private JFrame frame;
    private JPanel pane;
    private Timer timer;
    private int nextImage = 0;
    private String[] images = {"tokyo", "tokyo2", "starwars"};
    private Image img = null;
    public static void main (String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageSequence().createAndShowGui();
            }
        });
    }

    public void createAndShowGui() {
        frame = new JFrame("Image Sequence");
        timer = new Timer(1000, listener);
        pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    img = ImageIO.read(new FileInputStream("/home/jesus/Pictures/" + images[nextImage] + ".jpg"));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                g.drawImage(img , 0, 0, 200, 200, this);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }
        };

        timer.start();

        frame.getContentPane().add(pane);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    ActionListener listener = new ActionListener() {   
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println(nextImage);
            nextImage = nextImage < images.length - 1 ? nextImage + 1 : 0;
            System.out.println(nextImage);
            pane.repaint();
        }
    };
}
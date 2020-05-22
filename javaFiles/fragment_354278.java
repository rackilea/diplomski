import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

class OraclePaint extends JFrame {
    public static void main(String[] args) {
        OraclePaint ss = new OraclePaint();
        ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ss.add(new MyPanel());
        ss.setSize(250, 200);
        ss.setVisible(true);
    }
}

class MyPanel extends JPanel {
    private BufferedImage image = null;

    public MyPanel() {
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
                if (image != null) {

                    // Paint into the image
                    Graphics g = image.getGraphics();
                    g.setColor(Color.BLACK);
                    g.fillOval(event.getX(),  event.getY(), 22, 22);
                    g.dispose();

                    repaint();
                }
            }
        }); // end call to addMouseMotionListener
    }

    // Make sure that the image is not 'null' and that
    // it has the same size as this panel
    private void validateImage()
    {
        if (image == null)
        {
            image = new BufferedImage(getWidth(), getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        }
        if (image.getWidth() != getWidth() || image.getHeight() != getHeight())
        {
            BufferedImage newImage = new BufferedImage(getWidth(), getHeight(),
                BufferedImage.TYPE_INT_ARGB);
            Graphics g = newImage.getGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();
            image = newImage;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        validateImage();
        g.drawImage(image, 0, 0, null);
    }
}
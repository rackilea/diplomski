import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;

public class Main {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://i.imgur.com/o0E0aGD.png");
        BufferedImage bi = ImageIO.read(url);
        JFrame jf = new JFrame();

        jf.setTitle("test");
        jf.setLayout(new FlowLayout());
        //jf.setSize(350, 450); just pack()
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.add(new BackgroundImagePanel(bi));

        jf.pack();
        jf.setMinimumSize(jf.getSize());
        jf.setVisible(true);
    }
}

class BackgroundImagePanel extends JPanel {

    public Image img;

    // CONSTRUCTOR
    public BackgroundImagePanel(Image img) {
        this.img = img;
        this.setBorder(new LineBorder(Color.RED, 2));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
        // g.drawImage(img, 0, 0, getWidth(), getHeight(), this);  // Better!
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        int w = d.width>img.getWidth(this) ? d.width : img.getWidth(this);
        int h = d.height>img.getHeight(this) ? d.height : img.getHeight(this);

        return new Dimension(w, h);
    }
}
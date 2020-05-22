import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageTester {

public static void main(String[] args) throws Exception {
    final JFrame window = new JFrame("Image Tester");
    JButton draw = new JButton("Draw");
    JButton paint = new JButton("Paint");

    final Image i = ImageIO.read(new URL(
        "http://pscode.org/media/citymorn2.jpg"));

    ImagePanel gui = new ImagePanel();
    gui.setImage(i);
    draw.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent arg0) {
        }
    });

    paint.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
        }
    });

    gui.add(draw);
    gui.add(paint);
    window.add(gui);
    window.setVisible(true);
    window.setSize(new Dimension(400, 400));
    window.setLocationRelativeTo(null);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}

class ImagePanel extends JPanel {

    Image i;

    public void setImage(Image image) {
        i = image;
    }

    public void paintComponent(Graphics g) {
        //System.out.println(pane.getGraphics());
        super.paintComponent(g);
        g.drawRect(5, 5, 15, 15);
        g.drawImage(i, 15, 15, null);
        System.out.println("Performance");
    }
}
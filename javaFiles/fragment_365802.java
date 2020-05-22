import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RenderTest {

    RenderTest() {
        JPanel panel = new JPanel(new GridLayout(0,1,10,10));
        panel.setBackground(Color.RED);
        panel.setBorder(new EmptyBorder(5,25,5,25));

        JLabel label = new JLabel("hello");
        panel.add(label);
        JLabel label2 = new JLabel("goodbye");
        panel.add(label2);

        panel.addNotify();
        panel.setSize(panel.getPreferredSize());
        panel.validate();

        BufferedImage bi = getScreenShot(panel);
        JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(bi)));
    }

    private BufferedImage getScreenShot(JPanel panel){
        BufferedImage bi = new BufferedImage(
                panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_ARGB);
        panel.paint(bi.getGraphics());
        return bi;
    }

    public static void main(String[] args) {
        new RenderTest();
    }
}
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("my frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        JLabel label = new JLabel("my label");
        ImageIcon mouse = new ImageIcon("mouse.jpeg");
        label.setIcon(mouse);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        frame.add(label);
        frame.setVisible(true);
        frame.setSize(500, 500);


    }
}
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Test {
    public static void main(String[] args) {
        JFrame t = new JFrame();
        t.setBounds(100, 100, 500, 400);
        JLabel l = new JLabel("Hello");
        // new font size is 20
        l.setFont(new Font(l.getFont().getName(), l.getFont().getStyle(), 20));
        // draw label border to verify the new label size
        l.setBorder(new LineBorder(Color.BLACK));
        // change label size
        l.setPreferredSize(new Dimension(200, 200));
        t.getContentPane().setLayout(new FlowLayout());
        t.add(l);
        t.setVisible(true);
    }
}
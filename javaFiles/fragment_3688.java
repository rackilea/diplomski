import java.awt.*;

public class FrameTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Demo");
        jf.getContentPane().setLayout(new FlowLayout());

        // Ordinary button
        jf.add(new JButton("button 1"));

        // Smaller font
        jf.add(new JButton("button 2") {{ setFont(getFont().deriveFont(7f)); }});

        // Similar to your suggestion:
        jf.add(new JButton("button 3") {{
            Dimension d = getPreferredSize();
            d.setSize(d.getWidth(), d.getHeight()*.5);
            setPreferredSize(d);
        }});

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }
}